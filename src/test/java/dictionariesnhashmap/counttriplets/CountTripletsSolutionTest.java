package dictionariesnhashmap.counttriplets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CountTripletsSolutionTest {
    private final List<Long> arr;
    private final long r;
    private final long expectedResult;

    public CountTripletsSolutionTest(List<Long> arr, long r, long expectedResult) {
        this.arr = arr;
        this.r = r;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index}: number of triplets in array {0} with r={1} is {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<>(), 5, 0},
                {Arrays.asList(1L, 5L, 5L, 25L, 125L), 5, 4},
                {Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3, 6},
                {Arrays.asList(1L, 2L, 2L, 4L), 2, 2},
                {Arrays.asList(2L, 2L, 2L, 2L), 1, 84},
                {Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L), 1, 161700}
        });
    }

    @Test
    public void testCountTriplets() {
        // GIVEN
        // WHEN
        long nbTriplets = CountTripletsSolution.countTriplets(this.arr, this.r);
        // THEN
        assertThat(nbTriplets).isEqualTo(this.expectedResult);
    }
}