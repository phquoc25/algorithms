import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class BeautifulDayTest {

    BeautifulDay beautifulDay = spy(new BeautifulDay(20, 23, 6));

    @Test
    public void beautifulDays() {
        // GIVEN
        doReturn(2).when(beautifulDay).reverse(20);
        doReturn(12).when(beautifulDay).reverse(21);
        doReturn(22).when(beautifulDay).reverse(22);
        doReturn(32).when(beautifulDay).reverse(23);
        // WHEN
        int result = beautifulDay.getNbOfBeautifulDays();
        // THEN
        verify(beautifulDay).reverse(20);
        verify(beautifulDay).reverse(21);
        verify(beautifulDay).reverse(22);
        verify(beautifulDay).reverse(23);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testReverse() {
        Assert.assertEquals(0, beautifulDay.reverse(0));
        Assert.assertEquals(2, beautifulDay.reverse(20));
        Assert.assertEquals(12, beautifulDay.reverse(21));
        Assert.assertEquals(123, beautifulDay.reverse(321));
    }
}