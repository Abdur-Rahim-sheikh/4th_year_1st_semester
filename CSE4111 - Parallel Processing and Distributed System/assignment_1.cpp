#include<bits/stdc++.h>
#include<mpi.h>
using namespace std;

int main(int argc, char **argv){
    MPI_Init(NULL,NULL);

    int rank,all_process;
    MPI_Comm_size(MPI_COMM_WORLD,&all_process);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    
    printf("Total %d process this is in %d'th process\n",all_process,rank);

    MPI_Finalize();
    return 0;
}