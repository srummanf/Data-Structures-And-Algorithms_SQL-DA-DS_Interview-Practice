public class MaximumPointsObtainedFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int l = k - 1;
        int r = cardPoints.length - 1;

        int rightSum = 0;
        int score = 0;
        score = Math.max(score, (leftSum + rightSum));

        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[l--];
            rightSum += cardPoints[r--];
            score = Math.max(score, (leftSum + rightSum));
        }

        return score;

    }

    public static void main(String[] args) {
        MaximumPointsObtainedFromCards solution = new MaximumPointsObtainedFromCards();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(solution.maxScore(cardPoints, k)); // Output: 12
    }
}
