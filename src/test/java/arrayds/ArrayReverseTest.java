package arrayds;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ArrayReverseTest {

    private int[] input;
    private int[] expected;

    public ArrayReverseTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testReverse({0}) = {1}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{1, 4, 3, 2}, new int[]{2, 3, 4, 1}}
        });
    }

    @Test
    public void testReverse()
    {
        ArrayReverse arrayReverse = new ArrayReverse(input);
        arrayReverse.reverse();
        int[] actualResult = arrayReverse.getArray();
        Assert.assertArrayEquals(expected, actualResult);
    }
}