#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define INF 2147483648
#define mod 1000000007
#define ll long long
#define endl '\n'
#define PI (2*acos(0.0))
using namespace std;
char gap = 32;
template<typename T> 
ostream& operator<<(ostream &os, const vector<T> &v) { 
    os << '{'; 
    for (const auto &x : v) os << gap << x;
        return os << '}'; 
}
template<typename A, typename B> 
ostream& operator<<(ostream &os, const pair<A, B> &p) {
        return os << '(' << p.first <<gap<<','<< gap << p.second << ')';
}
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> 
void dbg_out(Head H, Tail... T) { 
    cerr << ' ' << H;
     dbg_out(T...); 
}
#define dbg(...) cerr << '(' << #__VA_ARGS__ << ')'<<':', dbg_out(__VA_ARGS__)
#define fastIO ios_base::sync_with_stdio(false); cin.tie(NULL);
#define mp make_pair
#define pb push_back
#define pii pair<int,int>
#define pll pair<ll,ll>
#define x first
#define y second
#define vi vector<int>
#define vvi vector<vi>
#define vll vector<ll>
#define on(val,pos) (val|(1<<pos))
#define off(val,pos) (val&(~(1<<pos)))
#define check(val,pos) (val&(1<<pos))
#define all(n) n.begin(),n.end()
//first four adjacent,second four corner
// first four also work for 90-degree clock-wise rotation
//int row[8]={0,1,0,-1,1,-1,-1,1};
//int col[8]={1,0,-1,0,-1,-1,1,1};
//using namespace __gnu_pbds;
//typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> ordered_set;
//replace less<int> to less_equal<int> to take duplicate values
#define vpsc vector<pair<string,char>>
void readString(vpsc & tokens,string s){
    string tem;
    stringstream ss(s);
    while(getline(ss,tem,';')){
        stringstream st(tem);
        string in,out;
        getline(st,out,'=');
        getline(st,in,'=');
        string inTokens;
        for(char x: in){
            if(x>='A' and x<='Z') inTokens+=x;
        }
        tokens.pb({inTokens,out[out.size()-2]});
    }
}
struct dep{
    string follow,anti,output;
};
int main(){
    int i,j,k,n,m,val,t=0,test;
    freopen("input.txt","r",stdin);
    string s,tem;
    while(getline(cin,tem)) s+=tem;
    vpsc tokens;
    readString(tokens,s);
    vector<dep> dependency(tokens.size()+1);
    for(i=0;i<tokens.size();i++){
        for(j=i+1;j<tokens.size();j++){
            int passed = 0;
            // match Condition follow dependency
            if(tokens[j].x.find(tokens[i].y)==string::npos){
                passed++;
            }
            else{
                dependency[j+1].follow+="p"+to_string(i+1)+" ";
            }
            
            // match condition anti dependency 
            if(tokens[i].x.find(tokens[j].y)==string::npos){
                passed++;
            }
            else{
                dependency[j+1].anti+="p"+to_string(i+1)+" ";
            }
            // match outputdependency
            if(tokens[i].y != tokens[j].y){
                passed++;
            }
            else{
                dependency[j+1].output+="p"+to_string(i+1)+" ";
            }

            if(passed == 3){
                printf("P%d parallel possible with P%d\n",i+1,j+1);
            }
        }
    }
    cout<<endl<<endl;
    for(i=1;i<dependency.size();i++){
        // cout<<"p"<<i<<" dependency:"<<endl;
        if(!dependency[i].follow.empty())
            cout<<"p"<<i<<" Follow dependent on: "<<dependency[i].follow<<endl;
        if(!dependency[i].anti.empty())
            cout<<"p"<<i<<" Anti   dependent on: "<<dependency[i].anti<<endl;
        if(!dependency[i].output.empty())
            cout<<"p"<<i<<" Output dependent on: "<<dependency[i].output<<endl;
        cout<<endl;
    }


    // for(auto x: tokens) cout<<x.x<<' '<<x.y<<endl;
    //free();   //if pointer array
    return 0;
}
