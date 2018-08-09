package arrayds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateLeftTest {

    RotateLeft rotateLeft = new RotateLeftWithoutTimeout();

    @Test
    public void testRotLeft() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] expectedResult = new int[]{5, 1, 2, 3, 4};
        int d = 4;
        int[] result = rotateLeft.rotate(arr, d);
        assertThat(result).hasSize(5).isEqualTo(expectedResult);
    }

    @Test
    public void testRotLeft1() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] expectedResult = new int[]{2, 3, 4, 5, 1};
        int d = 1;
        int[] result = rotateLeft.rotate(arr, d);
        assertThat(result).hasSize(5).isEqualTo(expectedResult);
    }

    @Test
    public void testRotLeft5() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] expectedResult = new int[]{1, 2, 3, 4, 5};
        int d = 5;
        int[] result = rotateLeft.rotate(arr, d);
        assertThat(result).hasSize(5).isEqualTo(expectedResult);
    }
}
