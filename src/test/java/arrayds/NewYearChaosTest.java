package arrayds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewYearChaosTest {
    @Test
    public void testMinimumBribes() {
        // GIVEN
        int[] qItems = new int[]{2, 1, 5, 3, 4};
        NewYearChaos newYearChaos = new NewYearChaos(qItems);
        // WHEN
        int minimumBribes = newYearChaos.minimumBribes();
        // THEN
        assertThat(minimumBribes).isEqualTo(3);
    }

    @Test
    public void testMinimumBribesShouldReturnMinus1WhenTooChaotics() {
        // GIVEN
        int[] qItems = new int[]{2, 5, 1, 3, 4};
        NewYearChaos newYearChaos = new NewYearChaos(qItems);
        // WHEN
        int minimumBribes = newYearChaos.minimumBribes();
        // THEN
        assertThat(minimumBribes).isEqualTo(-1);
    }
}
