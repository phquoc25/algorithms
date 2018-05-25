package arrayds;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Quoc PHAN on 25/05/2018.
 */
@RunWith(Parameterized.class)
public class BirthdayCakeCandlesTest {

    private int[] candles;
    private int nbCandlesFlewOut;

    public BirthdayCakeCandlesTest(int[] candles, int nbCandlesFlewOut)
    {
        this.candles = candles;
        this.nbCandlesFlewOut = nbCandlesFlewOut;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 1, 3, 2}, 2},
                {new int[]{3, 4, 3, 2}, 1}
        });
    }
    @Test
    public void testCalculateNbCandlesFlewOut() throws Exception
    {
        // GIVEN
        final BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        // WHEN
        int nbCandlesFlewOut = birthdayCakeCandles.calculateNbCandlesFlewOut(candles);

        // THEN
        Assert.assertEquals(this.nbCandlesFlewOut, nbCandlesFlewOut);
    }
}