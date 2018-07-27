/*
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 */
package timeconverter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Quoc PHAN on 26/07/2018.
 */
public class TimeConverterTest {
    @Test
    public void testTimeConverter() throws Exception
    {
        final String timeInput = "07:05:45PM";
        final String expectedOutput = "19:05:45";
        TimeConverter timeConverter = new TimeConverterImpl();
        String timeOutput = timeConverter.convert(timeInput);
        Assert.assertEquals(expectedOutput, timeInput);
    }
}
