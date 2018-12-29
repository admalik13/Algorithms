import java.util.Scanner;

/**
 * Implementation Notes.
 *
 * This is a sample implementation of Kadane's Algorithm
 * for solving the maximum subarray problem.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem">Maximum subarray problem</a>
 *
 * The Kadane's Alogrithm is as follows
 * 1. Initialize:
 *     local_maximum := 0
 *     global_maximum := negative infinity
 *
 * 2. Loop for each element of the array/stream of input integers
 *     a. local_maximum := local_maximum + a[i]
 *     b. if(local_maximum < 0) local_maximum := 0
 *     c. if(global_maximum < local_maximum) global_maximum := local_maximum
 *
 * 3. return global_maximum
 *
 * @author Aditya Malik
 */
public class Kadanes {
    private static final int ZERO = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases-- > ZERO){
            int arraySize = scan.nextInt();
            int inputArray[] = new int[arraySize];
            for(int index=0;index<arraySize;index++)
                inputArray[index] = scan.nextInt();

            System.out.println(getMaximumSumOfContiguousSubArray(inputArray));
        }
    }

    /**
     * Function getMaximumSumOfContiguousSubArray implements
     * Kadane's Algorithm
     *
     * @param array
     * @return maximum sum of contiguous sub array
     */
    private static int getMaximumSumOfContiguousSubArray(int array[]){
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        for(int index=0; index<array.length; index++){
            localMax += array[index];
            if(globalMax < localMax) globalMax = localMax;
            if(localMax < 0) localMax = 0;
        }
        return globalMax;
    }
}
