
# Interval Problems — Generic Boilerplates & Interview Playbook (Java)

These are problem-agnostic templates. In an interview, recognize which template fits, write the skeleton fast, then adapt the 2–3 lines that differ per problem.

---

## 0. Sorting comparators — get these right first

Most interval bugs are sorting bugs. Memorize these:

```java
// Sort by start ascending (default for merging / sweeping)
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// Sort by end ascending (default for greedy "keep max non-overlapping")
Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

// Sort by start ascending, tie -> end DESCENDING (covered-interval style)
Arrays.sort(intervals, (a, b) ->
        a[0] != b[0] ? Integer.compare(a[0], b[0])
                     : Integer.compare(b[1], a[1]));
```

**Trap:** never write `(a, b) -> a[0] - b[0]` in an interview if values can be large — subtraction overflows for extreme ints. `Integer.compare` is always safe and shows maturity.

---

## 1. Linear sweep template (the workhorse)

Fits: merging, counting survivors, detecting overlap, removing covered intervals.

```java
public void sweep(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    int prevEnd = Integer.MIN_VALUE;   // or seed with intervals[0]

    for (int[] curr : intervals) {
        if (curr[0] > prevEnd) {
            // CASE 1: disjoint — new block starts
            // action: append / count++ / finalize previous
            prevEnd = curr[1];
        } else if (curr[1] > prevEnd) {
            // CASE 2: partial overlap — extends the frontier
            // action: merge -> prevEnd = curr[1], or count a conflict
            prevEnd = curr[1];
        } else {
            // CASE 3: fully covered (curr[1] <= prevEnd)
            // action: skip / remove / count++
        }
    }
}
```

Write the three CASE comments *before* filling in logic — interviewers love seeing the case analysis up front, and it prevents missed branches.

---

## 2. Greedy "sort by end" template

Fits: maximum number of non-overlapping intervals, minimum removals, minimum arrows/resources to cover all.

```java
public int greedyByEnd(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

    int taken = 0;
    long prevEnd = Long.MIN_VALUE;

    for (int[] curr : intervals) {
        if (curr[0] >= prevEnd) {      // '>' if touching counts as overlap
            taken++;                    // keep this interval
            prevEnd = curr[1];
        }
        // else: conflicts with the chosen one -> drop it
    }
    return taken;                       // removals = n - taken
}
```

**Why end-ascending works:** finishing earliest leaves maximum room for the rest — the classic exchange-argument greedy. Be ready to say that sentence; interviewers often ask "why is this greedy correct?"

---

## 3. Min-heap of end times template

Fits: minimum rooms/machines/platforms needed, maximum concurrent intervals.

```java
public int minResources(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<Integer> ends = new PriorityQueue<>(); // earliest-ending active interval

    for (int[] curr : intervals) {
        if (!ends.isEmpty() && ends.peek() <= curr[0]) {
            ends.poll();               // a resource freed up -> reuse it
        }
        ends.offer(curr[1]);           // occupy a resource until curr[1]
    }
    return ends.size();                // peak concurrency
}
```

Heap size at any moment = number of intervals simultaneously active. O(n log n).

---

## 4. Sweep line / difference array template

Fits: "at any point in time, how many intervals overlap?", booking systems, seat/CPU load. Often the cleanest alternative to the heap.

```java
public int maxConcurrent(int[][] intervals) {
    // Event list: +1 at start, -1 at end
    List<int[]> events = new ArrayList<>();
    for (int[] in : intervals) {
        events.add(new int[]{in[0], +1});
        events.add(new int[]{in[1], -1});
    }
    // Sort by time; on tie, process -1 before +1 if touching is NOT overlap
    events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                       : Integer.compare(a[1], b[1]));
    int active = 0, best = 0;
    for (int[] e : events) {
        active += e[1];
        best = Math.max(best, active);
    }
    return best;
}
```

**The tie-break line is the whole interview.** Whether an interval ending at t and one starting at t "overlap" decides if -1 or +1 processes first. Always ask the interviewer.

If coordinates are small and dense, replace events with a plain difference array: `diff[start]++, diff[end]--`, then prefix-sum.

---

## 5. Two-pointer intersection template

Fits: intersection of two sorted interval lists, comparing two calendars.

```java
public List<int[]> intersect(int[][] A, int[][] B) {
    List<int[]> res = new ArrayList<>();
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
        int lo = Math.max(A[i][0], B[j][0]);   // intersection start
        int hi = Math.min(A[i][1], B[j][1]);   // intersection end
        if (lo <= hi) res.add(new int[]{lo, hi});

        // advance whichever interval ends first
        if (A[i][1] < B[j][1]) i++; else j++;
    }
    return res;
}
```

Memorize the one-liner: **intersection = [max(starts), min(ends)], valid iff max(starts) ≤ min(ends).** It replaces a page of if-else.

---

## 6. Insert-into-sorted template (three phases)

Fits: insert a new interval into an already-merged sorted list.

```java
public int[][] insert(int[][] intervals, int[] newIv) {
    List<int[]> res = new ArrayList<>();
    int i = 0, n = intervals.length;

    // Phase 1: everything strictly before newIv
    while (i < n && intervals[i][1] < newIv[0]) res.add(intervals[i++]);

    // Phase 2: absorb every overlapping interval into newIv
    while (i < n && intervals[i][0] <= newIv[1]) {
        newIv[0] = Math.min(newIv[0], intervals[i][0]);
        newIv[1] = Math.max(newIv[1], intervals[i][1]);
        i++;
    }
    res.add(newIv);

    // Phase 3: the rest
    while (i < n) res.add(intervals[i++]);

    return res.toArray(new int[res.size()][]);
}
```

---

## Choosing the template — a 10-second decision table


| The question asks for…                         | Template                         |
| ------------------------------------------------- | ---------------------------------- |
| Merge / consolidate / union                     | 1 (sweep, sort by start)         |
| Max non-overlapping / min removals / min arrows | 2 (greedy, sort by end)          |
| Min rooms / machines / platforms                | 3 (heap) or 4 (sweep line)       |
| Peak concurrency / load at a point              | 4 (sweep line)                   |
| Intersection of two lists                       | 5 (two pointers)                 |
| Insert one interval                             | 6 (three phases)                 |
| Is any pair overlapping? (yes/no)               | 1, return false on first overlap |

---

## Interview tips & tricks (what separates a good SDE candidate)

**Before coding**

- Restate the problem and immediately ask the two clarifying questions every interval problem has: *Do touching endpoints ([1,4] and [4,7]) count as overlapping?* and *Is the input sorted?* Asking these signals experience more than any code does.
- Say your plan in one sentence: "Sort by X, sweep tracking Y, and for each interval handle disjoint/overlap/covered." Get a nod before typing.
- State complexity up front: "Sorting dominates, so O(n log n) time, O(1) or O(n) space depending on whether I can mutate the input."

**While coding**

- Comparator hygiene: `Integer.compare`, never subtraction.
- Off-by-one discipline: every `<` vs `<=` in interval code corresponds directly to the touching-endpoints question you asked. Reference your clarification when you write it.
- Use `long` for `prevEnd` seeds (`Long.MIN_VALUE`) or seed from the first element — avoids sentinel-value bugs when real data contains `Integer.MIN_VALUE`.
- Name variables `prevEnd`, `maxEnd`, `active` — self-documenting beats comments in a 30-minute interview.

**After coding**

- Dry-run out loud on a 3–4 interval example including one nested pair — this catches the missing `Math.max` bug, the single most common interval mistake.
- Volunteer edge cases before being asked: empty input, one interval, all identical, one giant interval covering everything, fully nested chain.
- Mention the follow-up variants proactively: "If intervals streamed in one at a time, I'd keep a TreeMap of disjoint intervals" (this is the LeetCode 352 / calendar-booking family — a very common follow-up at Google/Amazon).

**Pattern recognition beyond LeetCode (real SDE relevance)**

- Interval logic is production code: meeting schedulers, CPU/task schedulers, hotel/seat booking, rate limiters, log time-range queries, garbage-collection pauses, IP range allocation. Mentioning one of these when asked "where would this apply?" shows systems thinking.
- The sweep-line idea (template 4) generalizes to 2D problems (skyline, rectangle area) — recognizing that connection is a strong senior signal.
- If asked to support *updates* (add/remove intervals dynamically), the answer is an ordered map (`TreeMap<Integer,Integer>` keyed by start) with `floorEntry`/`ceilingEntry` — know those two methods cold.

**General interview meta**

- Communicate trade-offs, not just solutions: "heap is simpler to reason about; sweep line uses less memory per event and handles the touching-endpoint semantics more explicitly."
- If stuck, fall back to the framework aloud: "Let me sort and enumerate the three cases" — recovering with structure beats silent staring.
- Write the brute force in one sentence first ("compare all pairs, O(n²)") so the interviewer knows you're optimizing deliberately, not guessing.


**Related problems (practice ladder)**

1. **56. Merge Intervals** — this pattern.
2. **57. Insert Interval** — three-phase scan: before, merge zone, after.
3. **435. Non-overlapping Intervals** — sort by end, greedy keep.
4. **452. Minimum Arrows to Burst Balloons** — 435 in disguise.
5. **1288. Remove Covered Intervals** — sort with tie-break, track `maxEnd`.
6. **252 / 253. Meeting Rooms I & II** — 253 adds a min-heap of end times.
7. **986. Interval List Intersections** — two pointers + the intersection one-liner.
