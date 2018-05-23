package twodarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Quoc PHAN on 23/05/2018.
 */
public class HourGlassTest {

    private HourGlassCalculator hourGlassCalculator = new HourGlassCalculator();

    @Test
    public void testGetMinSum() throws Exception
    {
        // GIVEN
        int[][] arr = new int[][] {
                {1, 1, 1, 3, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        // WHEN
        int result = hourGlassCalculator.calculateMaxHourGlassSum(arr);

        // THEN
        final List<HourGlass> hourGlasses = hourGlassCalculator.getHourGlasses();
        for (HourGlass hourGlass : hourGlasses) {
            final int[][] hourGlassArr = hourGlass.getArray();
            for (int i = 0; i < 3; i++) {
                System.out.println(Arrays.toString(hourGlassArr[i]));
            }
            System.out.println("===================================" + hourGlass.getSum());
        }
        Assert.assertEquals(19, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMinSumShouldThrowExceptionWhenInputInvalid() throws Exception
    {
        // GIVEN
        int[][] arr = new int[][] {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0}
        };

        // WHEN
        int result = hourGlassCalculator.calculateMaxHourGlassSum(arr);

        // THEN
        Assert.assertEquals(19, result);
    }
}