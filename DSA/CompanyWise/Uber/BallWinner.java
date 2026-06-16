/** Players a and b are playing the famous ball score game. there are some balls placed on a table with each with a value on it. game start with a coin toss. heads means a starts, else b starts. winner takes first turn. during each turn a player is allowed to pick at most k balls from table. score is sum of values of all balls taken by player. b will only pick ball whose sum of digits of ball is maximum, if theres a tie he chooses either one. a doesn't care about that he'll pick any ball. both want to maximize their score so both will play optimally. print the score both a and b will achieve.
 * 
 * 
 * Sure! Let's break down the problem with a detailed explanation and a dry run.

### Problem Breakdown

1. **Initial Setup:**
   - There are several balls on the table, each with a value on it.
   - A coin toss decides who starts the game:
     - If heads, player A starts.
     - If tails, player B starts.

2. **Turn Rules:**
   - On their turn, each player can pick up to `k` balls.
   - Player A can pick any balls without any specific strategy.
   - Player B will pick the ball(s) such that the sum of the digits of the ball's value is maximum. If there's a tie, B can choose any one of those balls.

3. **Objective:**
   - Both players aim to maximize their own score.
   - The game continues until there are no balls left to pick.

### Example Dry Run

Let's go through an example to illustrate how this would work:

#### Example Setup:
- Balls on the table: [10, 23, 56, 78, 34]
- Maximum balls a player can pick in one turn (`k`): 2
- Coin toss result: Heads (A starts)

#### Turns:

1. **Player A's Turn:**
   - A can pick any 2 balls (let's say A picks 10 and 23).
   - Scores:
     - A's score: 10 + 23 = 33
     - Balls remaining: [56, 78, 34]

2. **Player B's Turn:**
   - B will pick the ball(s) such that the sum of the digits is maximized.
   - Sum of digits for remaining balls:
     - 56: 5 + 6 = 11
     - 78: 7 + 8 = 15
     - 34: 3 + 4 = 7
   - B will pick 78 and 56 (since they have the highest digit sums and `k=2`).
   - Scores:
     - B's score: 78 + 56 = 134
     - Balls remaining: [34]

3. **Player A's Turn:**
   - A will pick the remaining ball(s) (let's say A picks 34).
   - Scores:
     - A's score: 33 + 34 = 67
     - Balls remaining: []

#### Final Scores:
- A's total score: 67
- B's total score: 134

### Explanation:
- Player A starts first and picks any 2 balls.
- Player B follows and picks the 2 balls with the highest sum of digits.
- The game continues until all balls are picked.
- Both players play optimally to maximize their scores.

By following this strategy, we ensure that both players are maximizing their scores according to the rules.
 */




