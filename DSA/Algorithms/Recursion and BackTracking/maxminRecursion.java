public class maxminRecursion {

    static class MaxMin {
        int max;
        int min;
    }

    static MaxMin findMaxMin(int[] arr, int low, int high) {
        MaxMin result = new MaxMin();

        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result.max = arr[low];
                result.min = arr[high];
            } else {
                result.max = arr[high];
                result.min = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        MaxMin left = findMaxMin(arr, low, mid);
        MaxMin right = findMaxMin(arr, mid + 1, high);

        if (left.max > right.max)
            result.max = left.max;
        else
            result.max = right.max;

        if (left.min < right.min)
            result.min = left.min;
        else
            result.min = right.min;

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 1, 8, 4, 9, 2, 5, 7 };

        MaxMin result = findMaxMin(arr, 0, arr.length - 1);

        System.out.println("Maximum element: " + result.max);
        System.out.println("Minimum element: " + result.min);
    }
}


