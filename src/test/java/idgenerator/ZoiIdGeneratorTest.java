package idgenerator;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ZoiIdGeneratorTest {
    private IdGenerator zoiIdGenerator = new ZoiIdGenerator();
    @Test
    public void testGenerateId_ShouldReturnAllZeros_WhenCurrentListIsEmpty()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000000";

        // WHEN
        String newId = zoiIdGenerator.generateId(new ArrayList<String>());
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }
    @Test
    public void testGenerateId_ShouldReturnAllZeros_WhenCurrentListAreUnFormattedId()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000000";
        List<String> idList = new ArrayList<String>();
        idList.add("a zoi id");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "10");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "9");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "13");

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }

    @Test
    public void testGenerateId_ShouldReturnAllZeros_WhenTheListIsFull()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000000";
        List<String> idList = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            idList.add(StringUtils.leftPad(String.valueOf(i), 6, '0'));
        }

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }

    @Test
    public void testGenerateId_ShouldReturnNextSequentialId_WhenCurrentListAreFormattedId()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000011";
        List<String> idList = new ArrayList<String>();
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000001");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000009");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000010");

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }

    @Test
    public void testGenerateId_ShouldReturnNextSequentialIdFromZero_WhenLatestIdReach1M()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000001";
        List<String> idList = new ArrayList<String>();
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000000");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000009");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "999999");

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }

    @Test
    public void testGenerateId_ShouldReturnNextSequentialIdFromZero_WhenLatestIdReach1M1()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000000";
        List<String> idList = new ArrayList<String>();
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "999999");

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }

    @Test
    public void testGenerateId_ShouldReturnNextSequentialIdFromZero_WhenLatestIdReach1M2()
    {
        // GIVEN
        String expectedId = ZoiIdGenerator.ZOI_ID_PREFIX + "000000";
        List<String> idList = new ArrayList<String>();
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000005");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "000009");
        idList.add(ZoiIdGenerator.ZOI_ID_PREFIX + "999999");

        // WHEN
        String newId = zoiIdGenerator.generateId(idList);
        // THEN
        assertThat(newId).isEqualTo(expectedId);
    }
}
