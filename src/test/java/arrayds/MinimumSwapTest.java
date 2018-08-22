package arrayds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumSwapTest {
    @Test
    public void testMinimumSwap()
    {
        // GIVEN
        int[] arr = new int[]{7, 1, 3, 2, 4, 5, 6};
        MinimumSwap minimumSwap = new MinimumSwap(arr);
        // WHEN
        minimumSwap.calculateMinimumSwap();
        // THEN
        assertThat(minimumSwap.getMinimumSwaps()).isEqualTo(5);
    }

    @Test
    public void testMinimumSwap1()
    {
        // GIVEN
        int[] arr = new int[]{4, 3, 1, 2};
        MinimumSwap minimumSwap = new MinimumSwap(arr);
        // WHEN
        minimumSwap.calculateMinimumSwap();
        // THEN
        assertThat(minimumSwap.getMinimumSwaps()).isEqualTo(3);
    }

    @Test
    public void testMinimumSwap2()
    {
        // GIVEN
        int[] arr = new int[]{2, 3, 4, 1, 5};
        MinimumSwap minimumSwap = new MinimumSwap(arr);
        // WHEN
        minimumSwap.calculateMinimumSwap();
        // THEN
        assertThat(minimumSwap.getMinimumSwaps()).isEqualTo(3);
    }

    @Test
    public void testMinimumSwap3()
    {
        // GIVEN
        int[] arr = new int[]{1, 3, 5, 2, 4, 6, 7};
        MinimumSwap minimumSwap = new MinimumSwap(arr);
        // WHEN
        minimumSwap.calculateMinimumSwap();
        // THEN
        assertThat(minimumSwap.getMinimumSwaps()).isEqualTo(3);
    }
}
