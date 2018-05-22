package sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Quoc PHAN on 22/05/2018.
 */
public class SortImplTest {

    private Sorter<Integer> sorter;
    private Integer[] array;
    private Integer[] expectedResult;

    @Before
    public void setUp() throws Exception
    {
        array = new Integer[]{1, 5, 8, 2, 4, 7};
        expectedResult = new Integer[]{1, 2, 4, 5, 7, 8};
    }

    @Test
    public void testElementarySort() throws Exception
    {
        // GIVEN
        sorter = new ElementarySortImpl<Integer>();
        // WHEN
        final Integer[] sortedArray = sorter.sort(array);
        // THEN
        Assert.assertArrayEquals(expectedResult, sortedArray);
    }
    @Test
    public void testSelectionSort() throws Exception
    {
        // GIVEN
        sorter = new SelectionSortImpl<Integer>();
        // WHEN
        final Integer[] sortedArray = sorter.sort(array);
        // THEN
        Assert.assertArrayEquals(expectedResult, sortedArray);
    }
}