import java.util.Scanner;

/**
 *
 * Problem Statement:
 * Given an array of size N-1 and given that there are numbers from 1 to N with one element missing,
 * the missing number is to be found.
 *
 * @see <a href="https://practice.geeksforgeeks.org/problems/missing-number-in-array/0">Missing Number in array</a>
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * For each test case first line contains N(size of array).
 * The subsequent line contains N-1 array elements.
 *
 * Output:
 * Print the missing number in array.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 *
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 5
 * 10
 * 1 2 3 4 5 6 7 8 10
 *
 * Output:
 * 4
 * 9
 *
 * Explanation:
 * Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 *
 * Solution:
 * This program provides an implementation for finding the missing
 * element in the array in O(n).
 *
 * 1. Index Based Method:
 *      In this method, the array elements are assigned to their
 *      corresponding index.
 *      Example:
 *      Value 1 will be assigned to Index 1, Value n to index n.
 *
 *      Then the missing element is searched using linear search.
 *
 * 2. Natural Number Sum Based Method
 *      In this method, the sum of all natual numbers is calculated
 *      using the formula n*(n+1)/2.
 *      Then all the array elements are deducted from the calculated sum.
 *
 * 3. XOR Based Method.
 *      1. Calculate XOR of all integer from 1 till array size.
 *      2. Calculate XOR of all elements inside the array.
 *      3. Perform XOR of results from step 1 and 2.
 *
 * @author Aditya Malik
 */
public class MissingNumber {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        /* Call the strategy that you want execute*/
        indexBasedStrategy(testCases, scanner);
        scanner.close();
    }

    /**
     * Implementation Details:
     *
     * 1. The Array Size is taken as N+1 (To prevent ArrayIndexOutOfBoundException)
     * 2. As all the number lies with the range of 1 to N, Map each number at its
     *    index.
     *    Example:
     *    Input:
     *    2
     *    5
     *    1 2 3 5
     *
     *    a. Initialize index 0 with negative infinity.
     *    b. Map Value 1 to index 1.
     *    c. Similarly Value n will be mapped to index n.
     *    d. At last we will have an index, which will have zero as its value.
     *       In this case, index 4.
     *  3. Search for index having value as 0.
     *
     * @param testCases how many TCs needs to be preformed
     * @param scanner for reading from STDIN
     */
    private static void indexBasedStrategy(int testCases, Scanner scanner) {
        while (testCases-- > ZERO){
            int arraySize = scanner.nextInt();
            int inputArray[] = new int[arraySize + ONE];
            inputArray[0]= Integer.MIN_VALUE;
            for(int counter=0; counter<arraySize - 1; counter++){
                int element = scanner.nextInt();
                inputArray[element] = element;
            }
            System.out.println(linearSearch(inputArray,ZERO));
        }
    }

    /**
     * Implementation Details:
     *
     * 1. Find out the sum of all natural numbers till the sizeOfArray.
     * 2. Subtract all the array elements from the calculated sum.
     * 3. You will now have only the missing element left in the sum variable.
     *
     * @param testCases how many TCs needs to be preformed
     * @param scanner for reading from STDIN
     */
    private static void naturalNumberSumBasedStrategy(int testCases, Scanner scanner) {
        while (testCases-- > ZERO){
            int arraySize = scanner.nextInt();
            int sumOfNaturalNumbers = (arraySize * (arraySize + 1)) / 2;
            for(int counter=0; counter<arraySize-1; counter++)
                sumOfNaturalNumbers -= scanner.nextInt();

            System.out.println(sumOfNaturalNumbers);
        }
    }

    /**
     * This method finds out the missing element in the array,
     * using XOR operator.
     *
     * Quick XOR tutorial:
     *  _________________
     * |__A__|__B__|_A^B_|
     * |  0  |  0  |  0  |
     * |  0  |  1  |  1  |
     * |  1  |  0  |  1  |
     * |  1  |  1  |  0  |
     *
     * @param testCases how many TCs needs to be preformed
     * @param scanner for reading from STDIN
     */
    private static void xorBasedStrategy(int testCases, Scanner scanner) {
        while (testCases-- > ZERO){
            int arraySize = scanner.nextInt();
            int inputArray[] = new int[arraySize - 1];
            for(int index=0; index<arraySize - 1; index++){
                inputArray[index] = scanner.nextInt();
            }
            System.out.println(xorOfAllElements(inputArray) ^ xorOfNaturalNumber(arraySize));
        }
    }

    /**
     * This function performs a linear search on the provided array,
     * for finding the provided key.
     *
     * @param array input integer array
     * @param key integer value that needs to be searched in the array
     * @return if key is found then index of the array else negative infinity
     */
    private static int linearSearch(int[] array, int key){
        for(int index=0; index<array.length; index++){
            if(array[index]==key) return index;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * This method returns XOR of all integers
     * till the provided limit.
     *
     * Note: The response is initialized with zero
     *       as any bit XOR'ed with zero will remain unchanged.
     *
     * @param limit any finite integer
     * @return XOR of all elements till the limit
     */
    private static int xorOfNaturalNumber(int limit) {
        int xoredElem = 0;
        for(int i=1; i<=limit;i++)
            xoredElem ^= i;

        return xoredElem;
    }

    /**
     * This method returns XOR of all numbers
     * inside an integer array.
     *
     * Note: The response is initialized with zero
     *       as any bit XOR'ed with zero will remain unchanged.
     *
     * @param inputArray any integer array
     * @return xor of all elements inside the provided array
     */
    private static int xorOfAllElements(int[] inputArray) {
        int xoredElem = 0;
        for(int element: inputArray)
            xoredElem ^= element;

        return xoredElem;
    }
}
