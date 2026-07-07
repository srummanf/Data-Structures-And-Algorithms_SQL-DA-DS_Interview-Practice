class Solution {
    long sumOfDigits(int n) {
        long sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            n = n / 10;
        }
        return sum;
    }

    long nonZeroDigits(int n) {
        String num = Integer.toString(n);
        if(n==0) return 0;
        String finalNum = "";
        for (char ch : num.toCharArray()) {
            if (ch != '0')
                finalNum += String.valueOf(ch);
        }

        return finalNum=="0"? 0 :Long.parseLong(finalNum);
    }

    public long sumAndMultiply(int n) {
        return sumOfDigits(n) * nonZeroDigits(n);
    }
}