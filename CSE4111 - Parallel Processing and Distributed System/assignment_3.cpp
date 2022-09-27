#include<bits/stdc++.h>
#include<mpi.h>
using namespace std;

int main(int argc, char **argv){
    MPI_Init(NULL,NULL);

    int rank,all_process;
    // MPI_Comm_size(MPI_COMM_WORLD,&all_process);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    
    if(rank&1) printf("World.\n");
    else printf("Hello.\n");

    MPI_Finalize();
    return 0;
}