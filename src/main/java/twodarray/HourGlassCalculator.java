/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package twodarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quoc PHAN on 23/05/2018.
 */
public class HourGlassCalculator {
    private static final int SIZE = 3;
    private List<HourGlass> hourGlasses = new ArrayList<HourGlass>();

    public int calculateMaxHourGlassSum(int[][] arr)
    {
        if (arr.length != 6) {
            throw new IllegalArgumentException("The array input must be in size 6 X 6");
        }
        int maxSum = Integer.MIN_VALUE;
        HourGlass hourGlass;
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                int[][] hourGlassArray = new int[3][3];
                hourGlassArray[0] = new int[]{ arr[i][j], arr[i][j + 1], arr[i][j + 2] };
                hourGlassArray[1] = new int[]{ 0, arr[i + 1][j + 1], 0 };
                hourGlassArray[2] = new int[]{arr[i + 2][j], arr[i + 2][j + 1], arr[i + 2][j + 2]};

                hourGlass = new HourGlass(hourGlassArray);
                hourGlasses.add(hourGlass);
                maxSum = Math.max(maxSum, hourGlass.getSum());
            }
        }
        return maxSum;
    }

    public List<HourGlass> getHourGlasses()
    {
        return hourGlasses;
    }
}
