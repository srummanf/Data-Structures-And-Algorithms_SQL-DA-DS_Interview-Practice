# The map contains islands, named from Island 1 to Island N. For any two islands Island / and Island J (I #J), you can go to Island J from Island / only if the value / divides J. (I is a divisor of J. Given the value for the last island, equal to N, find the number of ways to reach Island N from the first Island, that is, Island 1.

# Find the number of ways to reach Island N from Island 1.

# Note: Assume 1-based indexing.

# static long solve(int N){

# // Write your code here

# long result = 0;

# long dp[] = new long[N+1];
#  dp[1] = 1;
#  for(int i=1; i<=N; i++){
#  for(int j=2*i; j<=N; j+=1){ 
# dp[j]+=dp[i]; 
# } 

# }

# return dp[N]

# }


def solve(N):
    return dp[N]

# Precompute the dp array
MAX_N = 1000000
dp = [0] * (MAX_N + 1)
dp[1] = 1

for i in range(1, MAX_N + 1):
    ways = dp[i]
    for j in range(2 * i, MAX_N + 1, i):
        dp[j] += ways

T = int(input())
for _ in range(T):
    N = int(input())
    print(solve(N))