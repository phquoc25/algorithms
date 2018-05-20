package arrayds;

// PROBLEM
/**
 An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  (you may also see it written as ).

 Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.

 Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.

 Input Format

 The first line contains an integer,  (the number of integers in ).
 The second line contains  space-separated integers describing .

 Constraints

 Output Format

 Print all  integers in  in reverse order as a single line of space-separated integers.

 Sample Input 0

 4
 1 4 3 2
 Sample Output 0

 2 3 4 1
 */
public class ArrayReverse {

    private final int[] array;

    public ArrayReverse(int... numbers)
    {
        this.array = numbers;
    }

    public void reverse()
    {
        int arrSize = this.array.length;
        if (arrSize < 2) {
            return;
        }

        int mid = arrSize / 2;
        for(int i = 0; i < mid; i++) {
            swap(i, arrSize - i - 1);
        }
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int[] getArray() {
        return array;
    }
}
