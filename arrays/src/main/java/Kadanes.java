import java.util.Scanner;

/**
 * Implementation Notes.
 *
 * This is a sample implementation of Kadane's Algorithm
 * for solving the maximum subarray problem.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem">Maximum subarray problem</a>
 *
 * Problem Statement:
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 *
 * @see <a href="https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0">Kadane's Algorithm</a>
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * The first line of each test case contains a single integer N denoting the size of array.
 * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 106
 * -107 ≤ A[i] <= 107
 *
 * Example:
 * Input
 * 2
 * 5
 * 1 2 3 -2 5
 * 4
 * -1 -2 -3 -4
 * Output
 * 9
 * -1
 *
 * Explanation:
 * Testcase 1: Max subarray sum is 6 of elements (1, 2, 3) which is a contiguous subarray.
 *
 *
 * Solution:
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
     * @param array input array
     * @return maximum sum for a contiguous sub array
     */
    private static int getMaximumSumOfContiguousSubArray(int array[]){
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        for (int arrayElement : array) {
            localMax += arrayElement;
            if (globalMax < localMax) globalMax = localMax;
            if (localMax < 0) localMax = 0;
        }
        return globalMax;
    }
}
