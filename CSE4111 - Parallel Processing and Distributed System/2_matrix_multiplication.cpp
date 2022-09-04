#include<bits/stdc++.h>
// #include<mpi.h>
#define vi vector<int>
#define vvi vector<vi>
using namespace std;

vvi matmul(vvi arr,vvi brr){
    if(arr[0].size()!=brr.size()){
        printf("Multiplication not possible\n");
        exit(-1);
    }
    vvi ans(arr.size(),vi(brr[0].size(),0));
    int m=arr.size(),n=brr[0].size(),k=arr[0].size();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            for(int l=0;l<k;l++){
                ans[i][j] += arr[i][l]*brr[l][j];
            }
        }
    }

    return ans;
}
int main(int argc, char **argv){
    // vvi arr = {
    //     {1,1,1,1},
    //     {1,1,1,1},
    //     {1,1,1,1}
    // };
    // vvi brr = {
    //     {1,1,1,1},
    //     {1,1,1,1},
    //     {1,1,1,1},
    //     {1,1,1,1}
    // };
    int a,b;
    freopen("2_file.txt","r",stdin);
    scanf("%d %d",&a,&b);
    vvi arr(a,vi(b));
    for(auto &x: arr) for(auto &y: x)cin>>y;
    
    
    scanf("%d %d",&a,&b);
    vvi brr(a,vi(b));
    for(auto &x: brr) for(auto &y: x)cin>>y;
    

    printf("Multiplication is:\n");
    vvi ans = matmul(arr,brr);
    for(vi vals: ans){
        for(int val: vals) cout<<val<<' ';
        cout<<endl;
    }
    
    return 0;
}