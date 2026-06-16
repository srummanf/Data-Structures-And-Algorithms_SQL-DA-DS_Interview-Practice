# Game Theory

### What is Game Theory?

Game theory is a mathematical framework used for analyzing competitive situations where the outcomes depend on the actions of multiple participants, each with their own interests. In the context of algorithmic problems, game theory often involves two players making a series of decisions, with the goal of maximizing their own score while minimizing the opponent's score.

### Key Concepts

1. **Players**: Individuals or entities making decisions in the game.
2. **Strategies**: The choices available to players.
3. **Payoffs**: The outcomes of the game based on the players' strategies.
4. **Minimax Principle**: A strategy where a player minimizes the possible loss for a worst-case scenario (often used when trying to minimize the maximum possible loss).

### Common Game Theory Problems

- Two players alternately choosing from a set of options, with each player trying to maximize their score.
- Problems where the goal is to predict the outcome if both players play optimally.

## Skeleton Code in Java for Game Theory Problems

Here's a reusable skeleton for game theory problems in Java:

```java
class GameTheorySolution {
    public int solve(int player, int idx, int[] gameState, int[][] dp) {
        // Base case: when the game state is complete or invalid
        if (/* condition */)
            return /* result */;

        // Check memoization table
        if (dp[player][idx] != -1) 
            return dp[player][idx];

        // Initialize result based on player (1 for maximizing, 0 for minimizing)
        int result = player == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // Explore all possible moves
        for (int move = 1; move <= /* max moves possible */; move++) {
            // Calculate score or gameState changes
            int score = /* logic to update game state */;

            // Recursive call with the opposite player
            if (player == 1) {
                result = Math.max(result, score + solve(0, idx + move, gameState, dp));
            } else {
                result = Math.min(result, score + solve(1, idx + move, gameState, dp));
            }
        }

        // Store result in memoization table
        dp[player][idx] = result;
        return result;
    }

    public int gameTheoryProblem(int[] gameState) {
        // Initialize memoization table
        int[][] dp = new int[2][gameState.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < gameState.length; j++) {
                dp[i][j] = -1;
            }
        }

        // Start the game with player 1
        return solve(1, 0, gameState, dp);
    }
}
```

### How to Use:

1. **`player`**: Represents whose turn it is (1 for player trying to maximize, 0 for player trying to minimize).
2. **`idx`**: Current position or state in the game.
3. **`gameState`**: Array representing the current state of the game (e.g., piles of stones).
4. **`dp`**: Memoization table to store results and avoid redundant calculations.

### Sample LeetCode Questions

Here are some LeetCode problems that are based on game theory concepts:

| Problem Name        | Difficulty | Link                                                                        |
| ------------------- | ---------- | --------------------------------------------------------------------------- |
| Stone Game II       | Medium     | [LeetCode 1140](https://leetcode.com/problems/stone-game-ii/)                  |
| Predict the Winner  | Medium     | [LeetCode 486](https://leetcode.com/problems/predict-the-winner/)              |
| Stone Game          | Medium     | [LeetCode 877](https://leetcode.com/problems/stone-game/)                      |
| Nim Game            | Easy       | [LeetCode 292](https://leetcode.com/problems/nim-game/)                        |
| Minimax Tic-Tac-Toe | Hard       | [LeetCode 1275](https://leetcode.com/problems/minimax-tic-tac-toe/)            |
| Coin Game           | Medium     | [LeetCode 375](https://leetcode.com/problems/guess-number-higher-or-lower-ii/) |

This basic overview and skeleton code should help you get started with implementing game theory-related problems in Java. The suggested LeetCode problems provide a variety of scenarios to apply these concepts.
