# Walking Robot Simulation

## Overview

The `robotSim` function simulates a walking robot in a 2D plane, given a series of commands and obstacles. The robot starts at the origin (0,0) and can change direction or move forward based on the commands.

## Direction Handling

The robot can face four possible directions: **up**, **right**, **down**, and **left**. The direction is controlled by a variable `d` and a direction array `direction`:

```java
int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // up, right, down, left
int d = 0; // initially facing up
```

- `d = 0` → facing **up** (`{0, 1}`)
- `d = 1` → facing **right** (`{1, 0}`)
- `d = 2` → facing **down** (`{0, -1}`)
- `d = 3` → facing **left** (`{-1, 0}`)

### Changing Direction

The robot changes direction based on the commands:

- **-1** → Turn **right** (clockwise): Increase `d` by 1 and take modulo 4.
- **-2** → Turn **left** (counterclockwise): Increase `d` by 3 (equivalent to subtracting 1) and take modulo 4.

```java
if (i == -1) {
    d = (d + 1) % 4; // turn right
} else if (i == -2) {
    d = (d + 3) % 4; // turn left
}
```

### Moving Forward

For any positive command value, the robot moves forward by `i` units in the current direction. This is done iteratively, updating the position `(x, y)`:

```java
for (int j = 0; j < i; j++) {
    int nx = x + direction[d][0];
    int ny = y + direction[d][1];
    // Update the robot's position
    x = nx;
    y = ny;
    ans = Math.max(ans, x * x + y * y);
}
```

## Obstacle Detection

Obstacles are stored in a `HashSet` as strings in the format `"x,y"` for quick lookup:

```java
HashSet<String> obs = new HashSet<>();
for (int[] o : obstacles) {
    obs.add(o[0] + "," + o[1]);
}
```

When the robot attempts to move to a new position `(nx, ny)`, it first checks if this position is an obstacle:

```java
if (obs.contains(nx + "," + ny)) {
    break; // stop if there's an obstacle
}
```

If an obstacle is detected, the robot stops moving forward in the current direction and proceeds to the next command.

## Summary

- The robot uses a direction array and modular arithmetic to dynamically change direction based on the commands.
- The robot moves forward unless blocked by an obstacle, which is efficiently detected using a `HashSet`.
- The maximum Euclidean distance squared from the origin is tracked and returned as the result.

```

```
