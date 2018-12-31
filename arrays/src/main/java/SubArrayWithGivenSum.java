import java.util.Scanner;

/**
 * Problem Statement:
 *
 * Given an unsorted array A of size N of non-negative integers,
 * find a continuous sub-array which adds to a given number.
 *
 * @see <a href="https://www.geeksforgeeks.org/find-subarray-with-given-sum/">Find subarray with given sum</a>
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of two lines.
 * The first line of each test case is N and S, where N is the size of array and S is the sum.
 * The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of
 * first such occuring subarray from the left if sum equals to subarray, else print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 *
 * @author Aditya Malik
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0){
            int arraySize = scanner.nextInt();
            int requiredSum = scanner.nextInt();
            int array[] = new int[arraySize];

            for (int index=0; index < arraySize; index++)
                array[index] = scanner.nextInt();

            findAndPrintPosForRequiredSum(array, requiredSum);
        }
    }

    /**
     * Finds and prints starting and ending position of contiguous subarray
     * which adds up to the required sum.
     *
     * @param array - integer array
     * @param requiredSum - the sum required from a contiguous subarray
     */
    private static void findAndPrintPosForRequiredSum(int[] array, int requiredSum) {
        for(int index=0;index<array.length;index++){
            int sum = array[index];
            for(int secIndex=index+1;secIndex<=array.length;secIndex++){
                if(sum == requiredSum) {
                    System.out.println((index + 1) + " " + secIndex);
                    return;
                }
                if (sum > requiredSum || secIndex == array.length) break;
                sum += array[secIndex];
            }
        }
        System.out.println(-1);
    }
}
