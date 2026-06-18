class Solution {
    public double angleClock(int hour, int minutes) {

        double hour_angle = hour*30 + minutes*0.5;
        double minute_angle = minutes*6;
        double angle_diff = Math.abs(hour_angle - minute_angle);

        return (double)Math.min(angle_diff, 360 - angle_diff);

        
    }
}