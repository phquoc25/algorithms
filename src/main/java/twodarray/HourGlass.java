/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package twodarray;

/**
 * Created by Quoc PHAN on 23/05/2018.
 */
public class HourGlass {
    private int [][] array;
    private int sum;

    public HourGlass(int[][] array)
    {
        this.array = array;
        calculateSum();
    }

    private void calculateSum()
    {
        for (int[] anArray : array) {
            for (int j = 0; j < array.length; j++) {
                sum = sum + anArray[j];
            }
        }
    }

    public int getSum()
    {
        return sum;
    }

    public int[][] getArray()
    {
        return array;
    }
}
