/** We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.

When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time.

When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right, return the moment when the last ant(s) fall out of the plank.

Leetcode: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/ 

Explaination: https://www.youtube.com/watch?v=zv__otbvUEY */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AntCollision {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxmov = 0;
        for (int i : left) {
            maxmov = Math.max(maxmov, i);
        }
        for (int i : right) {
            maxmov = Math.max(maxmov, n - i);
        }
        return maxmov;
    }

    public static void main(String[] args) {
        int n = 4;
        int left[] = {4, 3};
        int right[] = {0, 1};
        AntCollision obj = new AntCollision();
        System.out.println(obj.getLastMoment(n, left, right));

        // Load and display the image
        try {
            BufferedImage image = ImageIO.read(new File("../assets/antcollision.png"));
            JFrame frame = new JFrame("Image Viewer");
            frame.add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

