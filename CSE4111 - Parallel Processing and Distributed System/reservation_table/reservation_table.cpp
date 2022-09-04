#include<bits/stdc++.h>
#define vv(x) vector<vector<x>>
#define v(x) vector<x>
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

collision_info* simulate(vv(int)& table,vv(int)& simulation,int start,int service){
    // int run = start;
    // note if we send a service i then
    // all service greater then i are considered erased.
    // (i starts from 1)

    for(int i=0,run=0;i<table.size();i++){
        
        v(pii) points = next(table,run,start);
        // cout<<run<<' '<<table.size()<<' '<<points.size()<<endl;
        for(pii u: points){
            if(!simulation[u.x][u.y] and simulation[u.x][u.y]<service){
                return new collision_info(u.x,u.y,simulation[u.x][u.y]);
            }
            simulation[u.x][u.y] = service;
        }
    }
    return new collision_info(false);
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
    cout<<"Collision vector: ";
    for(bool u: collision_vector) cout<<u<<' ';
    cout<<endl;
    
    // problem 3: simulation of problem
    vv(int) simulation(m,v(int)(3*n,0));
    // simulate first time
    // cout<<"here"<<endl;
    collision_info result = *simulate(arr,simulation,0,1);
    // cout<<"here"<<endl;
    int k,val;
    cin>>k;
    for(int i=0;i<k;i++){
        cin>>val;
        
        collision_info result = *simulate(arr,simulation,val,i+1);
        cout<<"Collission "<<(result.has==true?"occured:\n":"not happend.");
        if(result.has){
            cout<<"At stage: "<<result.x<<endl;
            cout<<"At time: "<<result.y<<endl;
            cout<<"With: "<<result.service<<endl;
        }
    }
    
    return 0;
}