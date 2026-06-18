// # Intuition
// A clock has two hands moving at different speeds. The minute hand moves **6° per minute**, while the hour hand moves **30° per hour** plus **0.5° per minute** as it gradually advances between hours. After calculating both angles from the 12 o'clock position, the answer is the smaller angle between them.

// # Approach

// ### Logic Breakdown

// **Minute Hand Position:**
// - A clock has **60 minutes**, and a full circle is **360°**, so the minute hand moves:
//   - `360° ÷ 60 = 6°` per minute.
// - Therefore:
//   - `Angle_m = minutes × 6`

// **Hour Hand Position:**
// - A clock has **12 hours**, so each hour mark is:
//   - `360° ÷ 12 = 30°`
// - The hour hand also moves continuously as the minutes pass.
// - It covers **30°** in **60 minutes**, so it moves:
//   - `30° ÷ 60 = 0.5°` per minute.
// - Therefore:
//   - `Angle_h = (hour × 30) + (minutes × 0.5)`

// **Smallest Angle:**
// 1. Compute the absolute difference between the two hand angles.
// 2. Since there are always two angles between the hands, return the smaller one:
//    - `min(difference, 360 - difference)`

// # Complexity
// - **Time complexity:** `O(1)`
// - **Space complexity:** `O(1)`


class AngleBetweenClock {
    public double angleClock(int hour, int minutes) {

        double hour_angle = hour*30 + minutes*0.5;
        double minute_angle = minutes*6;
        double angle_diff = Math.abs(hour_angle - minute_angle);

        return (double)Math.min(angle_diff, 360 - angle_diff);

        
    }

    public static void main(String[] args) {
        AngleBetweenClock obj = new AngleBetweenClock();
        System.out.println(obj.angleClock(12, 30)); // Output: 165.0
        System.out.println(obj.angleClock(3, 15));  // Output: 7.5
        System.out.println(obj.angleClock(9, 45));  // Output: 22.5
    }
}