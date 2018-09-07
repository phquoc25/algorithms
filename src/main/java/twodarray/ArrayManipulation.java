package twodarray;

import java.util.Arrays;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
 * For example, the length of your array of zeros n=10. Your list of queries is as follows:
 *     a b k
 *     1 5 3
 *     4 8 7
 *     6 9 1
 *
 * Add the values of k between the indices a and b inclusive:
 * index->	 1 2 3  4  5 6 7 8 9 10
 * 	        [0,0,0, 0, 0,0,0,0,0, 0]
 * 	        [3,3,3, 3, 3,0,0,0,0, 0]
 * 	        [3,3,3,10,10,7,7,7,0, 0]
 * 	        [3,3,3,10,10,8,8,8,1, 0]
 * The largest value is 10 after all operations are performed.
 *
 * Function Description
 *
 * Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.
 * arrayManipulation has the following parameters:
 * n - the number of elements in your array
 * queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
 *
 * Input Format
 *
 * The first line contains two space-separated integers n and m, the size of the array and the number of operations.
 * Each of the next m lines contains three space-separated integers a, b and k, the left index, right index and summand.
 *
 * Constraints
 * 3 <= n <= 10^7
 * 1 <= m <= 2*10^5
 * 1 <= a <= b <= n
 * 0 <= k <= 10^9
 *
 * Output Format
 *
 * Return the integer maximum value in the finished array.
 * Sample Input
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 * Sample Output
 * 200
 *
 * Explanation
 * After the first update list will be 100 100 0 0 0.
 * After the second update list will be 100 200 100 100 100.
 * After the third update list will be 100 200 200 200 100.
 * The required answer will be 200.
 */
public class ArrayManipulation {
    private final int n;
    private final int[][] queries;

    public ArrayManipulation(int n, int[][] queries) {
        this.n = n;
        this.queries = queries;
    }

    /**
     * Instead of storing the actual values in the array, you store the difference between the current element and the previous element.
     * So you add sum to a[p] showing that a[p] is greater than its previous element by sum.
     * You subtract sum from a[q+1] to show that a[q+1] is less than a[q] by sum (since a[q] was the last element that was added to sum).
     * By the end of all this, you have an array that shows the difference between every successive element.
     * By adding all the positive differences, you get the value of the maximum element
     * @return
     */
    public long manipulate() {
        long[] sumArr = new long[this.n];
        int length = this.queries.length;
        int from;
        int to;
        int sum;
        for (int i = 0; i < length; i++) {
            from = queries[i][0];
            to = queries[i][1];
            sum = queries[i][2];
            sumArr[from - 1]+= sum;

            if (to < this.n) {
                sumArr[to]-= sum;
            }
        }

        return Arrays.stream(sumArr).filter(value -> value > 0).sum();
    }
}
