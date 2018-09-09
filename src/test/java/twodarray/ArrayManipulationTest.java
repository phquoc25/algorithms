package twodarray;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayManipulationTest {
    private ArrayManipulation arrayManipulation;

    @Test
    public void testManipulate() {
        // GIVEN
        int n = 5;
        int[][] queries = new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        arrayManipulation = new ArrayManipulation(n, queries);
        // WHEN
        long actualResult = arrayManipulation.manipulate();
        // THEN
        assertThat(actualResult).isEqualTo(200);
    }
}
