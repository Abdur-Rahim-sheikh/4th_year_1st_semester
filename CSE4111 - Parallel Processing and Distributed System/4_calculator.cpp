#include<bits/stdc++.h>
#include<mpi.h>
using namespace std;

int main(int argc, char **argv){
    // for(int i=0;i<argc;i++)cout<<argv[i]<<endl;
    int a,b;
    a = stoi(argv[1]);
    b = stoi(argv[2]);
    MPI_Init(NULL,NULL);
    
    // scanf("%d %d",&a,&b);

    int rank,all_process;
    MPI_Comm_size(MPI_COMM_WORLD,&all_process);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    if(rank==0) printf("summation %d\n",a+b);
    else if(rank==1) printf("Subtraction %d\n",a-b);
    else if(rank==2) printf("Multiplication %d\n",a*b);
    else if(rank==3) printf("Division %d\n",a/b);
    else printf("%d'th process has no operation to perform\n",rank);
    

    MPI_Finalize();
    return 0;
}