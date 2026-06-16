/** Find the minimum cost of traveling between two tram stations in a circular city with N stations numbered from 1 to N. The cost of tickets between adjacent stations is given in an array ticket_cost, where ticket_cost[i] represents the cost of traveling from station i to station (i+1)% N. Trams can move in both clockwise and anti- clockwise directions. The input includes N, the start station, and the finish station. The output should be the minimum cost of traveling from start to finish station.

30 >

Function description

Complete the Solve() function. This function takes the following arguments and finds the minimum cost to travel between the given start and finish station:

N. Represen the total number of tram stations

start: Represents the start station

finish, Represents the finish station

ticket_cost: Represents ticket_cost[i] denoting the ticket-cost between the station number i and (i + 1) %N


Input format

Java 8 (

• The first line contains an integer N denoting the total number of tram stations.

1>

im

25 sta

26

27

28

29

• The second line contains an integer start denoting the start station.

• The third line contains an integer finish denoting the finish station.

30 >}...

• The fourth line contains an N space-separated Integer array ticket_cost, ticket_cost[i] represents the ticket-cost between the station number / and (1+1) %N.

Output format

Return the minimum cost to travel between the given start and finish station.

Constraints

1 < N < 105

0start, finish < N

0 ticket_cost i < 107

Sample input 
4
1
3
1 2 3 4

Output: 3

import java.io.*;...

25

static long solve(int N, int start, int finish, int[] Ticket_cost){

26

// Write your code here

27

long result = 0;

28

29

return result;

30 >} */

static long solve(int N, int start, int finish, int[] ticket_cost) {
    if (start == finish) {
        return 0;
    }

    long totalCost = 0;
    for (int cost : ticket_cost) {
        totalCost += cost;
    }

    long clockwiseCost = 0;
    int clockwiseSteps = 0;

    // Calculate clockwise cost
    for (int i = start; i != finish; i = (i + 1) % N) {
        clockwiseCost += ticket_cost[i];
        clockwiseSteps++;
    }

    // The counterclockwise cost is the total cost minus the clockwise cost
    long counterClockwiseCost = totalCost - clockwiseCost;
    int counterClockwiseSteps = N - clockwiseSteps;

    // Return the minimum of clockwise and counterclockwise costs
    return Math.min(clockwiseCost, counterClockwiseCost);
}