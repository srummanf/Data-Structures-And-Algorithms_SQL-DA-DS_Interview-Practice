/** There are ‘N’ junctions connected by ‘M’ bi-directional roads. At most, one road is present between any pair of junctions. There is no road connecting a junction to itself. The travel time for a road is the same in both directions.

A vehicle at a junction can start moving along a road only when the light at the current junction flashes green. If a vehicle arrives at a junction between green flashes, it must wait for the next green flash before continuing in any direction. If it arrives at a junction exactly when the light flashes green, it can immediately proceed along any road originating from that junction.

You are given a city map that shows travel times for all roads. For each junction ‘i’, you are given ‘P[i]’, the time period between green flashes of the light at that junction. The light at junction ‘i’ flashes green at times 0, P[i], 2P[i], 3P[i] and so on.

Your task is to return the minimum time taken from a given source junction ‘src’ to a given destination junction ’des’ for a vehicle when the traffic starts. The junctions are identified by integers ‘0’ through ‘N - 1’. If we cannot reach the destination junction, then return -1.

For example:
Consider if ‘N’ = 3 and edges are 
[[0, 1, 2],
 [1, 2, 4]]
'P' = [2, 3, 4], and we have to reach from junction 0 to 2.
The time consumed from junction 0 to 1 is 2. We have to wait for 1 for the next green flash at junction 1. The time consumed from junction 1 to 2 is 4. The path 0 -> 1 -> 2 takes time 2 + 1 (wait till 3) + 4 = 7. Hence, the answer is 7.
Input Format :
The first line contains a single integer ‘T’ representing the number of test cases.

The first line of each test case contains two space-separated integers, ‘N’ and ‘M’, denoting the number of junctions and roads.

The next line contains ‘N’ space-separated integers denoting the elements of the array ‘P’ elements where ‘P[i]’ is the time needed at junction ‘i’ for light to turn green.

The next ‘M’ lines of each test case contain three space-separated integers denoting the road between ‘Edges[i][0]’ and ‘Edges[i][1]’ junctions with ‘Edges[i][2]’ denoting the time to travel the road.

The last line of each test case contains two space-separated integers, 'src' and 'des', denoting the source and destination junctions. 
Output Format :

For each test case, print a single integer that denotes the minimum time needed from the junction ‘src’ to ‘des’. Print ‘-1’ in case we cannot reach the ‘des’ junction.

Print the output of each test case in a separate line.
Constraints
1 <= T <= 5
2 <= N <= 10^5
1 <= M <= 10^5
1 <= P[i] <= 10^7
0 <= Edges[i][0] , Edges[i][1] < N
1 <= Edges[i][2] <= 10^7
0 <= src, des < ‘N’

Time limit: 1 sec */