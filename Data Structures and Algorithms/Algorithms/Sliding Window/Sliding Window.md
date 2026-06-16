# Sliding Window is one of the most asked patterns in interviews.

But most people only practice fixed size windows.
Then they see a variable window problem and go completely blank.

There are 3 types of Sliding Window problems.
Here is the complete guide with the exact template for each.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
THE CORE IDEA — WHY SLIDING WINDOW WORKS
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

A brute force approach checks every subarray — O(n²) or worse.
Sliding Window avoids recomputing from scratch every time.

Instead of starting over, you:
→ ADD the new element entering the window from the right
→ REMOVE the old element leaving the window from the left

This keeps the window updated in O(1) per step → O(n) total.

For Sliding Window to work, one condition must hold:

If a window [l, r] is INVALID, then [l, r+1] is also invalid.
If a window [l, r] is VALID, then [l-1, r] is also valid.
In other words — validity must be MONOTONIC as the window grows.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
TYPE 1 — FIXED SIZE WINDOW
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

When to use:
→ Window size k is given explicitly in the problem
→ Find max/min/average of every subarray of size k

Keywords: "subarray of size k", "window of length k",
"every k consecutive elements"

THE TEMPLATE:

```cpp
int l = 0;
<initialize window with first k elements>

for (int r = k; r < n; r++) {
    <add nums[r] to window>
    <remove nums[l] from window>
    l++;
    <update answer>
}
```

EXAMPLE — Maximum Average Subarray I

[https://leetcode.com/problems/maximum-average-subarray-i](https://leetcode.com/problems/maximum-average-subarray-i)

```cpp
double findMaxAverage(vector<int>& nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++) sum += nums[i];

    double maxSum = sum;
    for (int r = k; r < nums.size(); r++) {
        sum += nums[r] - nums[r - k];   // add right, remove left
        maxSum = max(maxSum, sum);
    }
    return maxSum / k;
}
```

EXAMPLE — Maximum Sum of Distinct Subarrays With Length K

[https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k)

Track frequency of elements in a map.
Window is valid when all elements are distinct.

```cpp
long long maximumSubarraySum(vector<int>& nums, int k) {
    unordered_map<int, int> freq;
    long long sum = 0, ans = 0;
    int l = 0;

    for (int r = 0; r < nums.size(); r++) {
        freq[nums[r]]++;
        sum += nums[r];

        if (r - l + 1 == k) {
            if (freq.size() == k) ans = max(ans, sum);
            sum -= nums[l];
            if (--freq[nums[l]] == 0) freq.erase(nums[l]);
            l++;
        }
    }
    return ans;
}
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
TYPE 2 — VARIABLE SIZE WINDOW
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

When to use:
→ Window size is not fixed — it grows and shrinks
→ Find the longest/shortest subarray that satisfies a condition

Keywords: "longest subarray with", "smallest subarray with",
"at most k", "flip at most k", "max consecutive"

This is where most people get stuck.
The window expands from the right and shrinks from the left.

THE TEMPLATE:

```cpp
int l = 0;
<initialize tracking variable>

for (int r = 0; r < n; r++) {
    <add nums[r] to window>

    while (<window is invalid>) {
        <remove nums[l] from window>
        l++;
    }

    <update answer — window [l, r] is now valid>
}
```

Key insight: r always moves forward. l only moves forward too.
Both pointers never go back → O(n) total.

EXAMPLE — Longest Subarray of 1's After Deleting One Element

[https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element)

Window condition: at most one 0 in the window.
Shrink when zeros exceed 1.

```cpp
int longestSubarray(vector<int>& nums) {
    int l = 0, zeros = 0, ans = 0;
    for (int r = 0; r < nums.size(); r++) {
        if (nums[r] == 0) zeros++;
        while (zeros > 1) {
            if (nums[l] == 0) zeros--;
            l++;
        }
        ans = max(ans, r - l);   // r - l not r - l + 1 (deleted one)
    }
    return ans;
}
```

EXAMPLE — Fruit Into Baskets

[https://leetcode.com/problems/fruit-into-baskets](https://leetcode.com/problems/fruit-into-baskets)

Window condition: at most 2 distinct fruit types.
Shrink when distinct types exceed 2.

```cpp
int totalFruit(vector<int>& fruits) {
    unordered_map<int, int> basket;
    int l = 0, ans = 0;
    for (int r = 0; r < fruits.size(); r++) {
        basket[fruits[r]]++;
        while (basket.size() > 2) {
            basket[fruits[l]]--;
            if (basket[fruits[l]] == 0) basket.erase(fruits[l]);
            l++;
        }
        ans = max(ans, r - l + 1);
    }
    return ans;
}
```

EXAMPLE — Max Consecutive Ones III

[https://leetcode.com/problems/max-consecutive-ones-iii](https://leetcode.com/problems/max-consecutive-ones-iii)

Window condition: at most k zeros allowed (can flip k zeros).

```cpp
int longestOnes(vector<int>& nums, int k) {
    int l = 0, zeros = 0, ans = 0;
    for (int r = 0; r < nums.size(); r++) {
        if (nums[r] == 0) zeros++;
        while (zeros > k) {
            if (nums[l] == 0) zeros--;
            l++;
        }
        ans = max(ans, r - l + 1);
    }
    return ans;
}
```

EXAMPLE — Subarray Product Less Than K

[https://leetcode.com/problems/subarray-product-less-than-k](https://leetcode.com/problems/subarray-product-less-than-k)

Window condition: product of all elements < k.
Shrink from left when product >= k.
Count every valid subarray ending at r.

```cpp
int numSubarrayProductLessThanK(vector<int>& nums, int k) {
    if (k <= 1) return 0;
    int l = 0, prod = 1, ans = 0;
    for (int r = 0; r < nums.size(); r++) {
        prod *= nums[r];
        while (prod >= k) prod /= nums[l++];
        ans += r - l + 1;   // all subarrays ending at r are valid
    }
    return ans;
}
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
TYPE 3 — SLIDING WINDOW ON STRINGS
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

When to use:
→ Input is a string
→ Find longest/shortest substring with a character condition
→ Find all substrings matching a pattern or anagram

Keywords: "substring", "anagram in string", "minimum window",
"longest without repeating", "character replacement"

Same variable window template — but track characters with a
frequency map instead of a single counter.

THE TEMPLATE:

```cpp
unordered_map<char, int> window;
int l = 0, <condition tracker>;

for (int r = 0; r < s.size(); r++) {
    <add s[r] to window map>
    <update condition tracker>

    while (<window is invalid>) {
        <remove s[l] from window map>
        <update condition tracker>
        l++;
    }

    <update answer>
}
```

EXAMPLE — Longest Substring Without Repeating Characters

[https://leetcode.com/problems/longest-substring-without-repeating-characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)

Window condition: no duplicate characters.

```cpp
int lengthOfLongestSubstring(string s) {
    unordered_map<char, int> freq;
    int l = 0, ans = 0;
    for (int r = 0; r < s.size(); r++) {
        freq[s[r]]++;
        while (freq[s[r]] > 1) {
            freq[s[l]]--;
            l++;
        }
        ans = max(ans, r - l + 1);
    }
    return ans;
}
```

EXAMPLE — Longest Repeating Character Replacement

[https://leetcode.com/problems/longest-repeating-character-replacement](https://leetcode.com/problems/longest-repeating-character-replacement)

You can replace at most k characters.
Window is valid if: (window size - max frequency) <= k
The part that is NOT the most frequent char needs replacing.

```cpp
int characterReplacement(string s, int k) {
    int freq[26] = {}, maxFreq = 0, l = 0, ans = 0;
    for (int r = 0; r < s.size(); r++) {
        maxFreq = max(maxFreq, ++freq[s[r] - 'A']);
        while ((r - l + 1) - maxFreq > k) {
            freq[s[l] - 'A']--;
            l++;
        }
        ans = max(ans, r - l + 1);
    }
    return ans;
}
```

EXAMPLE — Find All Anagrams in a String

[https://leetcode.com/problems/find-all-anagrams-in-a-string](https://leetcode.com/problems/find-all-anagrams-in-a-string)

Fixed size window of size p.size().
Window matches when frequency map equals pattern frequency.

```cpp
vector<int> findAnagrams(string s, string p) {
    if (s.size() < p.size()) return {};
    int freq[26] = {}, window[26] = {};
    for (char c : p) freq[c - 'a']++;
    for (int i = 0; i < p.size(); i++) window[s[i] - 'a']++;

    vector<int> ans;
    if (equal(freq, freq + 26, window)) ans.push_back(0);

    for (int r = p.size(); r < s.size(); r++) {
        window[s[r] - 'a']++;
        window[s[r - p.size()] - 'a']--;
        if (equal(freq, freq + 26, window)) ans.push_back(r - p.size() + 1);
    }
    return ans;
}
```

EXAMPLE — Minimum Window Substring (Hard)

[https://leetcode.com/problems/minimum-window-substring](https://leetcode.com/problems/minimum-window-substring)

Find smallest window in s that contains all chars of t.
Track how many chars from t are currently satisfied.

```cpp
string minWindow(string s, string t) {
    unordered_map<char, int> need, have;
    for (char c : t) need[c]++;
    int formed = 0, required = need.size();
    int l = 0, minLen = INT_MAX, start = 0;

    for (int r = 0; r < s.size(); r++) {
        char c = s[r];
        have[c]++;
        if (need.count(c) && have[c] == need[c]) formed++;

        while (formed == required) {
            if (r - l + 1 < minLen) { minLen = r - l + 1; start = l; }
            have[s[l]]--;
            if (need.count(s[l]) && have[s[l]] < need[s[l]]) formed--;
            l++;
        }
    }
    return minLen == INT_MAX ? "" : s.substr(start, minLen);
}
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
HOW TO IDENTIFY WHICH TYPE — DECISION GUIDE
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Read the problem. Ask these questions:

Is the window size k fixed and given?
→ YES → Type 1 (Fixed Window)

Is the input a string with a character condition?
→ YES → Type 3 (String Window)

Is the input an array with a numeric condition
and the window can grow or shrink?
→ YES → Type 2 (Variable Window)

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
COMMON MISTAKES AND HOW TO AVOID THEM
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

MISTAKE 1 — Using while vs if to shrink

Always use WHILE not IF when shrinking.
Multiple elements may need to leave before the window is valid.

MISTAKE 2 — Off by one in window size

Window size = r - l + 1
If you deleted an element (like in Longest Subarray of 1s)
the answer is r - l, not r - l + 1.

MISTAKE 3 — Trying Sliding Window when it does not apply

Sliding Window needs MONOTONIC validity.
If adding one element can make the window valid again after
it was invalid, Sliding Window will not work.
Example: "subarray with sum exactly k and negative numbers"
→ use Prefix Sum + Hash Map instead.

MISTAKE 4 — Forgetting to shrink the window

After expanding with r, always check if the window
is still valid. If not — shrink from l.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
PRACTICE PROBLEMS — IN ORDER
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Type 1 — Fixed Window (start here)

Maximum Average Subarray I
[https://leetcode.com/problems/maximum-average-subarray-i](https://leetcode.com/problems/maximum-average-subarray-i)

Maximum Sum of Distinct Subarrays With Length K
[https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k)

Type 2 — Variable Window

Longest Subarray of 1's After Deleting One Element
[https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element)

Max Consecutive Ones III
[https://leetcode.com/problems/max-consecutive-ones-iii](https://leetcode.com/problems/max-consecutive-ones-iii)

Fruit Into Baskets
[https://leetcode.com/problems/fruit-into-baskets](https://leetcode.com/problems/fruit-into-baskets)

Binary Subarrays With Sum
[https://leetcode.com/problems/binary-subarrays-with-sum](https://leetcode.com/problems/binary-subarrays-with-sum)

Count Number of Nice Subarrays
[https://leetcode.com/problems/count-number-of-nice-subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays)

Subarray Product Less Than K
[https://leetcode.com/problems/subarray-product-less-than-k](https://leetcode.com/problems/subarray-product-less-than-k)

Subarrays With K Different Integers (Hard)
[https://leetcode.com/problems/subarrays-with-k-different-integers](https://leetcode.com/problems/subarrays-with-k-different-integers)

Type 3 — String Window

Longest Substring Without Repeating Characters
[https://leetcode.com/problems/longest-substring-without-repeating-characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)

Longest Repeating Character Replacement
[https://leetcode.com/problems/longest-repeating-character-replacement](https://leetcode.com/problems/longest-repeating-character-replacement)

Find All Anagrams in a String
[https://leetcode.com/problems/find-all-anagrams-in-a-string](https://leetcode.com/problems/find-all-anagrams-in-a-string)

Minimum Window Substring (Hard)
[https://leetcode.com/problems/minimum-window-substring](https://leetcode.com/problems/minimum-window-substring)

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
THE UNIVERSAL TEMPLATE — ONE FOR ALL 3 TYPES
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

```cpp
int l = 0;
<initialize window state>

for (int r = 0; r < n; r++) {
    <add element at r to window>

    while (<window is invalid>) {
        <remove element at l from window>
        l++;
    }

    <update answer with current valid window [l, r]>
}
```

The only thing that changes per problem:
→ What "window state" you track (sum, freq map, zero count)
→ What "invalid" means for that problem
→ What answer you extract (max length, min length, count)

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

> Link  : [How To Solve ANY Sliding Window Problem - Step By Step Guide Along With Problem Examples](https://leetcode.com/discuss/post/8336805/how-to-solve-any-sliding-window-problem-srrx7/ "Leetcode Blog")
