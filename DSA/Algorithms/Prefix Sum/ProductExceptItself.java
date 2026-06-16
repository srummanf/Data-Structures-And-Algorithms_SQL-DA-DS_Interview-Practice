/**
 * ProductExceptItself
 * Solution: https://www.youtube.com/watch?v=bNvIQI2wAjk
 * Concept : Prefix, Postfix Multiplication
 * prefix:
->
|       a       |   a*b   | a*b*c | a*b*c*d |
postfix:
<-
| a*b*c*d | b*c*d |   c*d   |      d        |

the result is a multiply without the symbol in own position (the left value from prefix and the right one from postfix):
|    b*c*d  | a*c*d | a*b*d |   a*b*c   |
 */
public class ProductExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int prefix = 1;
        for(int i=0;i<n;i++){
            ans[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        ProductExceptItself p = new ProductExceptItself();
        int nums[] = {1,2,3,4};
        int ans[] = p.productExceptSelf(nums);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}