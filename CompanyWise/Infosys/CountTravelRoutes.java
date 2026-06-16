/** There are 
𝑁 cities and each of these cities has 𝑀 checkpoints.

You are given a 2D array A where each checkpoint at city 
𝑖
i is connected by A[i][j] outgoing directed roads to checkpoint 
𝑗
j at city 
𝑖
+
1
i+1 (the checkpoints at city 
𝑁
N don't have any outgoing roads).

You are given a 2D array Queries of size 
𝑄
Q. Each query will be given in either of the following two types:

Type 1 - 1 C X Y Z: You can change the number of outgoing roads from checkpoint 
𝑋
X at city 
𝐶
C to checkpoint 
𝑌
Y at city 
𝐶
+
1
C+1 to 
𝑍
Z.
Type 2 - 2 P Q X Y: Find the total number of ways you can go from checkpoint 
𝑋
X at city 
𝑃
P to checkpoint 
𝑌
Y at city 
𝑄
Q.
Find the sum of answers for queries of Type 2. Since the answer can be large, return it modulo 
1
0
9
+
7
10 
9
 +7.

Input Format
The first line contains an integer, 
𝑁
N, denoting the number of cities.
The next line contains an integer, 
𝑀
M, denoting the checkpoints in the cities.
The next line contains an integer, total, denoting the number of rows in array Road.
Each of the next total lines contains 
𝑀
M space-separated integers describing the row Road[i].
The next line contains an integer, 
𝑄
Q, denoting the number of rows in array Queries.
Each of the next 
𝑄
Q lines contains five space-separated integers describing the row Queries[i].
Sample Input

4
3
3
1 2 3
2 3 1
3 1 2
4
5
1 1 2 1 5
2 1 3 2 3
1 3 1 3 2
2 2 4 1 2
2 1 4 2 3
Sample Output

11
Explanation
Input Details:

𝑁
=
4
N=4: 4 cities
𝑀
=
3
M=3: Each city has 3 checkpoints
Road array:

1 2 3
2 3 1
3 1 2
Queries array:
graphql

1 1 2 1 5  (Type 1 query)
2 1 3 2 3  (Type 2 query)
1 3 1 3 2  (Type 1 query)
2 2 4 1 2  (Type 2 query)
2 1 4 2 3  (Type 2 query)
Queries Execution:

Type 1: Change the number of outgoing roads from checkpoint 1 at city 1 to checkpoint 2 at city 2 to 5.
Type 2: Calculate the number of ways to go from checkpoint 2 at city 1 to checkpoint 3 at city 3.
Type 1: Change the number of outgoing roads from checkpoint 1 at city 3 to checkpoint 3 at city 4 to 2.
Type 2: Calculate the number of ways to go from checkpoint 1 at city 2 to checkpoint 2 at city 4.
Type 2: Calculate the number of ways to go from checkpoint 2 at city 1 to checkpoint 3 at city 4.
Output Calculation:

Sum of answers for all Type 2 queries: 
11
11 (Example sum based on hypothetical scenario). */

class CountTravelRoutes{

}