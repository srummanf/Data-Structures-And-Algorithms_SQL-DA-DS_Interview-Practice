Refer: https://leetcode.com/discuss/post/5453529/intuit-oa-questions-sde-july-2024-by-ano-lwx0/



Date : 10/07/2024
Question 1. Russian Dolls

Oleg has N dolls of various sizes. He can place the smaller dolls inside the larger ones, but he cannot place the same-sized dolls inside each other. He needs to find the minimum number of dolls that remain when the maximum number of dolls have been packed.

* Input
  The first line of input contains an integer N. representing the number of dolls initially. The second line consists of N space-separated integers representing the size of dolls.
* Constraints
  `1 ≤ N ≤ 105`
  `1 ≤ size of doll ≤ 105`
* Output
  Print an integer representing the minimum number of dolls Oleg has after placing all smaller dolls inside the larger dolls.
* Example #1
  * Input : -
    4
    2 2 3 3
  * Output : -
    2
    Explanation:
  * In order to be left with the minimum number of dolls, Oleg will do the following:
    Put the doll at index 1 inside the doll at index 3, i.e.. the doll of size two in size three.
    Put the doll at index 2 inside the box at index 4, i.e., the doll of size two in size three.
    Now he is left with two dolls of size three which cannot be further placed inside each other. So, the output is 2.
* Example #2
  * Input : -
    6
    1 2 2 3 4 5
  * Output : -
    2
  * Explanation:
    Oleg will place the dolls at index (1, 2, 4, 5) in the doll at index 6. So, he will be left with two dolls of sizes two and five.

Question 2. Virus Spread

You are given a petri dish with a grid with some healthy cells at locations i.j. It is of dimensions N x M. where each grid point in the dish can only have the
following values:
0: Empty
1: Has a healthy cell
2: Has a virus cell

Unfortunately, a virus can make its healthy neighbors sick (infected), and you need to find a minimum time at which all the cells have the virus. A virus-cell at in location [i,j] will infect healthy cells at [i-1,j], [i+1,j], [j-1], [i, j+1] (up, down, left and right), and this takes place in one second of time. If not all cells in the dish are infected with the virus, then return-1.

* Input
  The first line of input contains the number of rows (N)
  The second line of input contains the number of columns (M).
  Next, N lines of the input contain the M space- separated elements that indicate elements in each row of the matrix.
* Output
  Print an integer that denotes the minimum time for all cells to have the virus, or print -1 if not all cells in the dish are infected.
* Constraints
  `1<= M <= 100`
  `1<=N<=100`
  `0 <= ar[i] <= 2`
* Example #1
  * Input
    2
    3
    2 0 0
    1 1 1
  * Output
    3
  * Explanation: The virus cell at (0.1) will infect the healthy cell at (0.0) after one second. After the next second, the virus in (0,0) will infect the healthy cell at (1.0), and after the third second, the healthy cell in the lower right will be infected.
* Example #2
  * Input
    2
    3
    2 0 1
    1 1 0
  * Output
    -1
  * Explanation: The healthy cell in the top right will not be infected since it is surrounded by empty cells.

Question 3. KING-DREAMS-I

Once upon a time, a King saw a dream, where if his kingdom has `good line` of `tanks`, meaning `tanks` lined up side by side in a certain way, they will become invincible.

Now, since you are the advior of the king, he has asked you to create a `good line` of tanks. There are `m` types of tanks, numbered 1 through `m` and we have infinite amount of tanks for each type.

Come up with a `<span> </span>good line` of size `n` tanks. If there are multiple `<span> </span>good line` return one which is lexographically smallest.

`good line` is a configuration where tanks lined up in an array and the count of subarrays with only distinct tank types is maximum. e.g (3, 4, 4, 5) contains 6 subarrays with distinct tanks: (3), (4), (4), (5), (3, 4), (4, 5)

An array ? is lexicographically smaller than an array ? if there exists an index? such that ?? <??, and ???? for all 15?<?. Less formally, at the first index? in which they differ. ??<??

* Constraints
  `1< n<= 100000 1 <= m <= 10000000`
* Sample Input
  * Example 1
    * Input: n = 1, m = 2
    * Output: 1
    * Explanation: Max subarrays count with distinct tanks for line size 1 is 1. Possible line (1). (2) We choose (1) as it is lexographically smallest.
  * Example 2
    * Input: n = 2, m = 1
    * Output: 11
    * Explanation: The only possible line - (1, 1)
  * Example 3
    * Input: n = 2, m = 2
    * Output: 12
    * Explanation: Possible lines: (1, 1), (1, 2), (2, 1). (2, 2) Lines (1, 2) and (2, 1) has max count of subarrays with distinct tanks.

Question 4. SPREADING FIRE

There is a 2D plane of size N*M. There is fire which is there at K different points in the 2D plane. From each of these K points, the fire is spreading in a circular form with the radius of the fire increasing by time.
So, if at t=1, the radius of fire (represented by R) was 2. at t = 2 it becomes 4, at t = 3 it become 6 and so on. "t" denotes time here.
Help us determine, the number of points (points are denoted by (x,y). where both x and y are whole numbers, and are within the plane) which would not be touched by the fire.

* Constraints
  `1 <= N <= 1000`
  `1 <= M <= 1000`
  `1 <= K <= 5`
  `1 <= R <= 10`
  `1 <= T <= 100`
* Input Format
  The first line has 3 space separated integer N, M and K, dimensions of the 2D plane and the number of fire points
  Next K lines each having 2 space separated integers, stating the coordinates of the fire.
  Next line denotes the R, the radius of the fire at t=1,
  Next line contain an integer T. stating the time at which we want to know points not touched by fire
* Sample Input
  4 4 2
  1 1
  3 3
  1
  2
* Sample Output
  6
* Explanation
  0,3
  0,4
  1,4
  3,0
  4,0
  4,1
  Fire does not reach these 6 points

Question 5. JUMPING KADY

Kady is very energetic guy and he is fond of jumping. He is standing on a two dimension plane of size m*n square units. Plane is partitioned into unit squares. So in total there are m*n squares. Kady has his favourite number 'X', so each time when he will jump he will take jump of 'X' units.

In short, plane can be considered as a 2D matrix. Kady is currently standing at position S(p.q) where p is pth row of matrix and q is qth column of matrix. Kady wants to go from his position S to new position R(u,v) by taking jumps of exactly X units each time.

Determine if kady can reach his destination or not. If he can reach, print the minimum number of jumps he need to take to go from S to R.

Note:

1. Kady cannot go out of plane. If he do so then he will fall off the plane and dies.
2. If Kady wants to take jump from point A to B then jump is only feasible if Euclidean distance between these two points is X.

* Constraints
  `1 ≤ m, n ≤ 1000`
  `1 ≤ x ≤ 1000`
* Input Format
  The first line contains two integers m, n and X where m is number of rows and n is favourite number of Kady.
  The second line contains two integers p and q (Kady's initial position).
  The third line contains two integers u and v (Kady's destination position).
* Output Format
  If Kady can reach his destination position then print minimum number of jumps he need to take else print-1.
* Sample Input
  6 5 5
  1 2
  2 5
* Sample Output
  2
* Explanation
  In starting Kady is standing at position (1,2). From here he can jump to point (6,2) by taking 5 units of jump. From (6.2) he can go to (2,5) which is also at a distance of 5 units from his position
