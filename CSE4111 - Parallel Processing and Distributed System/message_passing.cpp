#include<stdio.h> 
#include<mpi.h> 
#include<iostream>
#include<stdlib.h> 
#include <vector>

#define vi vector<int>
using namespace std;
int main(int argc, char* argv[])
{
	int my_rank,nProcess;
	int N = 12, section = 12/4, values[200], subArray[200];

	MPI_Status status;

	MPI_Init(&argc, &argv);

	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
	MPI_Comm_size(MPI_COMM_WORLD, &nProcess);
	if (my_rank == 0) {
		//MPI_Recv(&numbertoreceive, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
		printf("Given 12 random values:\n");
		int values[20] = { 1,2,3,4,5,6,7,8,9,10,11,12 };

		MPI_Send(values, section, MPI_INT, 2, 10, MPI_COMM_WORLD);
		MPI_Send(values + section, section, MPI_INT, 3, 10, MPI_COMM_WORLD);
		MPI_Send(values + 2 * section, section, MPI_INT, 4, 10, MPI_COMM_WORLD);
		MPI_Send(values + 3 * section, section, MPI_INT, 1, 10, MPI_COMM_WORLD);

		//Now lets recieve them
		int total = 0;
		for (int i = 0;i < 4;i++) {
			int value;
			MPI_Recv(&value, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
			total += value;
		}
		printf("Back to origin rank: %d\n total sum got: %d\n", my_rank, total);
	}
	else {
		MPI_Recv(&subArray, section, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
		int sum = 0;
		for (int i = 0;i < 3;i++) {
			sum += subArray[i];
		}
		printf("from %d rank: %d is sum\n", my_rank, sum);
		MPI_Send(&sum, 1, MPI_INT, 0, 10, MPI_COMM_WORLD);
	}
	

	printf("ranking: %d\n", my_rank);

	MPI_Finalize();

	return 0;
}