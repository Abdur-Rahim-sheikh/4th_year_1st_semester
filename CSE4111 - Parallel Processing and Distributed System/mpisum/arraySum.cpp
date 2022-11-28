#include<bits/stdc++.h>
#include<mpi.h>
using namespace std;
int N,piece;
int main(){
    int rank,total;
    int array[200],subArray[200];
    MPI_Init(NULL,NULL);
    
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    MPI_Comm_size(MPI_COMM_WORLD,&total);
    // printf("in rank: %d of total process: %d\n",rank,total);

    if(rank==0){
        cout<<"Give Number of values, and then Number:"<<endl;
        cin>>N;
        for(int i=0;i<N;i++)cin>>array[i];
        int state = N/(total-1);
        for(int i=1;i<total;i++){
            MPI_Send(&state,1,MPI_INT,i,10,MPI_COMM_WORLD);
            MPI_Send(array+(i-1)*state,state,MPI_INT,i,10,MPI_COMM_WORLD);
        }
        int sum = 0;
        for(int i=state*(total-1);i<N;i++)sum+=array[i];
        for(int i=1;i<total;i++){
            int tem;
            MPI_Recv(&tem,1,MPI_INT,i,10,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
            sum+=tem;
        }
        printf("Final sum: %d\n",sum);
    }
    else{
        int state;
        MPI_Recv(&state,1,MPI_INT,MPI_ANY_SOURCE,MPI_ANY_TAG,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        MPI_Recv(&subArray,state,MPI_INT,MPI_ANY_SOURCE,MPI_ANY_TAG,MPI_COMM_WORLD,MPI_STATUS_IGNORE);
        int sum = 0;
        for(int i=0;i<state;i++) sum += subArray[i];
        printf("In rank %d: sum is %d\n",rank,sum);
        MPI_Send(&sum,1,MPI_INT,0,10,MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}