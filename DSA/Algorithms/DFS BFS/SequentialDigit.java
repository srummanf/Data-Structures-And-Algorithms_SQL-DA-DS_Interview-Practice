package BFS;

class Solution {

  public List<Integer> sequentialDigits(int low, int high) {
    Set<Integer> checkSeq = new HashSet<>();
    int len[] = {0,1,11,111,1111,11111,111111,1111111,11111111,111111111};
    List<Integer> ans = new ArrayList<>();
    checkSeq.add(12);
    checkSeq.add(23);
    checkSeq.add(34);
    checkSeq.add(45);
    checkSeq.add(56);
    checkSeq.add(67);
    checkSeq.add(78);
    checkSeq.add(89);
    checkSeq.add(123);
    checkSeq.add(234);
    checkSeq.add(345);
    checkSeq.add(456);
    checkSeq.add(567);
    checkSeq.add(678);
    checkSeq.add(789);
    checkSeq.add(1234);
    checkSeq.add(2345);
    checkSeq.add(3456);
    checkSeq.add(4567);
    checkSeq.add(5678);
    checkSeq.add(6789);
    checkSeq.add(12345);
    checkSeq.add(23456);
    checkSeq.add(34567);
    checkSeq.add(45678);
    checkSeq.add(56789);
    checkSeq.add(123456);
    checkSeq.add(234567);
    checkSeq.add(345678);
    checkSeq.add(456789);
    checkSeq.add(1234567);
    checkSeq.add(2345678);
    checkSeq.add(3456789);
    checkSeq.add(12345678);
    checkSeq.add(23456789);
    checkSeq.add(123456789);
    for (int i = low; i <= high; i= i++) {
      if (checkSeq.contains(i)) {
        ans.add(i);
        String s = Integer.toString(i);
        int l = s.length();
        i = i + len[l];
        if(i<=high){
        ans.add(i);
        }
        System.out.println(i + "--" + l);
      }

    }
    return ans;
  }
}



class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequentialNumbers = new ArrayList<>();
      
        // Start generating numbers from each digit 1 through 8
        // A sequential digit number cannot start with 9 as it would not have a consecutive next digit
        for (int startDigit = 1; startDigit < 9; ++startDigit) {
            // Initialize the sequential number with the current starting digit
            int sequentialNum = startDigit;
          
            // Append the next digit to the sequential number, starting from startDigit + 1
            for (int nextDigit = startDigit + 1; nextDigit < 10; ++nextDigit) {
                // Append the next digit to the current sequential number
                sequentialNum = sequentialNum * 10 + nextDigit;
              
                // Check if the newly formed sequential number is within the range [low, high]
                if (sequentialNum >= low && sequentialNum <= high) {
                    // If it is within the range, add it to the answer list
                    sequentialNumbers.add(sequentialNum);
                }
            }
        }
      
        // Sort the list of sequential numbers
        Collections.sort(sequentialNumbers);
      
        // Return the list containing all valid sequential digit numbers in the range
        return sequentialNumbers;
    }
}


