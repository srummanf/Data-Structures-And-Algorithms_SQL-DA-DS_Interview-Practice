/**
### Explanation:

1. **Modulo Operation:**
   ```java
   k = k % (2 * (n - 1));
   ```
   This line ensures that `k` is within the range `[0, 2 * (n - 1) - 1]`. This is important for the oscillation effect, similar to how a pendulum repeats its motion periodically.

2. **Determining the Position:**
   ```java
   if (k <= n - 1)
       return k;
   else
       return 2 * (n - 1) - k;
   ```
   - If `k` is within the first half of the range (`0` to `n - 1`), it returns `k` directly.
   - If `k` is in the second half of the range (`n` to `2 * (n - 1) - 1`), it returns `2 * (n - 1) - k`.

### Visualization:

To better understand, let's consider an example with `n = 5` and visualize the values of `k`:

- The range of `k` after modulo operation: `[0, 2 * (n - 1) - 1]` translates to `[0, 8]`.

- For `k` values from `0` to `4` (inclusive):
  - The function returns `k` itself.
- For `k` values from `5` to `8` (inclusive):
  - The function returns `2 * (n - 1) - k`.

Here's how the values are mapped:
- `k = 0`: returns `0`
- `k = 1`: returns `1`
- `k = 2`: returns `2`
- `k = 3`: returns `3`
- `k = 4`: returns `4`
- `k = 5`: returns `3` (because `2 * 4 - 5 = 3`)
- `k = 6`: returns `2` (because `2 * 4 - 6 = 2`)
- `k = 7`: returns `1` (because `2 * 4 - 7 = 1`)
- `k = 8`: returns `0` (because `2 * 4 - 8 = 0`)

This forms a pattern like:
```
0, 1, 2, 3, 4, 3, 2, 1, 0
```

### Pendulum Analogy:

This pattern is analogous to the motion of a pendulum or an oscillating object. The pendulum swings from one extreme (0) to the other extreme (4) and back to the original extreme (0):

- The pendulum moves forward from position `0` to position `4`.
- Then it moves backward from position `4` to position `0`.

The code effectively simulates this back-and-forth motion, making it useful in scenarios where such oscillatory behavior is needed. */

public class PendulumMotion {

  public int oscillation(int n, int k) {
    k = k % (2 * (n - 1));
    if (k <= n - 1) {
      return k;
    } else {
      return 2 * (n - 1) - k;
    }
  }
}
