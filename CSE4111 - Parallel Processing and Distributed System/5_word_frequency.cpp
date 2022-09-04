#include<bits/stdc++.h>
#define pis pair<int,string>
#define vi vector<int>
using namespace std;
// bool comp(psi &a,psi &b){
//     return a.first>b.first;
// }
int main(int argc,char **argv){
    string s,tem;
    freopen("5_file.txt","r",stdin);
    map<string,int> value;
    vector<pair<int,string>> occurance;
    while(getline(cin,s)){
        stringstream ss(s);
        while(ss>>tem){
            value[tem]++;
        }
    }
    for(auto it: value) occurance.push_back({it.second,it.first});
    sort(occurance.begin(),occurance.end(),greater<pis>());
    for(auto val: occurance) cout<<val.second<<' '<<val.first<<endl;

    return 0;
}