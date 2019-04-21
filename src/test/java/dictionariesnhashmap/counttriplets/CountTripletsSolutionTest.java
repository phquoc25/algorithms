package dictionariesnhashmap.counttriplets;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTripletsSolutionTest {

    @Test
    public void countTriplets() {
        // GIVEN
        List<Long> arr = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        long r = 5;
        // WHEN
        long nbTriplets = CountTripletsSolution.countTriplets(arr, r);
        // THEN
        assertThat(nbTriplets).isEqualTo(4);
    }
}