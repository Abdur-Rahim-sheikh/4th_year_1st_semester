#include<bits/stdc++.h>
#define vv(x) vector<vector<x>>
#define v(x) vector<x>
#define check(x,i) (x & (1<<i))>0
#define nextStage(icv,cur,i) (icv | (cur>>i))
#define pii pair<int,int>
#define x first
#define y second
using namespace std;

v(int) getForbidden(vv(int) &arr){
    set<int> st;
    for(auto u: arr){
        for(int i=0;i<u.size();i++){
            if(!u[i])continue;
            for(int j=i+1;j<u.size();j++){
                if(u[j]) st.insert(j-i);
            }
        }
    }
    // v(int) ans(st.begin(),st.end());
    return v(int) (st.begin(),st.end());
}
v(pii) next(vv(int) &table,int &run,int start){
    v(pii) points;
    for(int i=0;i<table.size();i++){
        if(table[i][run]==1)points.push_back({i,run+start});
    }
    run++;
    return points;
}
struct collision_info{
    int x,y,service;
    bool has;
    collision_info(bool has):has(has){};
    collision_info(int x,int y,int service):x(x),y(y),service(service),has(true){};
};

void printTable(vv(int) box){
    int i=0;
    for(auto u: box){
        i++;
        if(u.empty())continue;
        cout<<i-1<<": ";
        for(auto v:u){
            cout<<v<<' ';
        }
        cout<<endl;
    }
}

collision_info* simulate(vv(int)& table,vv(int)& simulation,int start,int &service){
    // int run = start;
    // note if we send a service i then
    // all service greater then i are considered erased.
    // (i starts from 1)

    for(int i=0,run=0;i<table[0].size();i++){
        
        v(pii) points = next(table,run,start);

        for(pii u: points){
            if(simulation[u.x][u.y]!=0 and simulation[u.x][u.y]<service){
                return new collision_info(u.x,u.y,simulation[u.x][u.y]);
            }
            simulation[u.x][u.y] = service;
        }
    }
    // the service is completed
    service++;
    return new collision_info(false);
}

vv(int) BFS(int start,int icv,int columns){
    v(bool) visited(1000,0);
    vv(int) network(1<<columns);
    visited[start] = true;
    queue<int> q;
    q.push(start);
    while(!q.empty()){
        int cur = q.front();
        // cout<<cur<<endl;
        q.pop();
        for(int i=0;i<columns;i++){
            if(check(cur,i) == 0){
                int stage = nextStage(icv,cur,i+1);
                network[cur].push_back(stage);
                if(visited[stage]==0){
                    visited[stage]=true;
                    q.push(stage);
                }
            }
        }
        
    }
    return network;
}
string bin(int n,int k){
    string s;
    for(int i=n-1;i>=0;i--){
        s+=((k & (1<<i))>0)+'0';
    }

    return s;
}
void BFSPrint(vv(int)&network,int start,int n){
    int i=0;
    cout<<bin(n,2)<<endl;
    for(auto u: network){
        i++;
        if(u.empty())continue;
        bin(n,i-1);
        for(auto v:u){
            cout<<bin(n,v)<<' ';
        }
        cout<<endl;
    }
}

int main(){
    int m,n;
    freopen("input.txt","r",stdin);
    cin>>m>>n;
    vv(int) arr(m,v(int)(n,0));
    for(auto &u: arr) for(auto &v: u) cin>>v;

    // problem 1: forbidden latencies
    v(int) forbidden = getForbidden(arr);
    cout<<"Forbidden: ";
    for(int u: forbidden) cout<<u<<' ';
    cout<<endl;

    // problem 2: permissible latencies
    v(int) permissible;
    cout<<"Permissible: ";
    for(int i=1,j=0;i<=n;i++){
        if(j<forbidden.size() and i==forbidden[j]){j++;continue;}
        permissible.push_back(i);
        cout<<i<<' ';
    }
    cout<<endl;

    // problem 3: collision vector
    v(bool) collision_vector(forbidden[forbidden.size()-1],false);
    for(int u: forbidden) collision_vector[u-1] = true;

    reverse(collision_vector.begin(),collision_vector.end());
    cout<<"Collision vector: ";
    for(bool u: collision_vector) cout<<u<<' ';
    cout<<endl;
    
    // problem 4: simulation of problem
    vv(int) simulation(m,v(int)(3*n,0));
    
    int k,val,service=1;
    collision_info result = *simulate(arr,simulation,0,service);
    
    cin>>k;
    for(int i=0;i<k;i++){
        cin>>val;
        
        collision_info result = *simulate(arr,simulation,val,service);
        cout<<"For "<<val<<" latency ";
        cout<<"collission "<<(result.has==true?"occured:\n":"not happend.\n");
        if(result.has){
            cout<<"At stage: "<<result.x<<endl;
            cout<<"At time: "<<result.y<<endl;
            cout<<"With: "<<result.service<<endl;
        }
        // printTable(simulation);
    }

    // problem 5: stateTransition from collision vector
    int icv =0;
    for(int i=0;i<collision_vector.size();i++){
        int p = collision_vector.size()-i-1;
        if(collision_vector[i]){
            icv |= (1<<p);
        }
    }
    cout<<icv<<endl;
    
    vv(int) diagram = BFS(icv,icv,n);
    BFSPrint(diagram,icv,n);

    // printTable(diagram);
    
    return 0;
}