package com.interview.speakingclock.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.interview.speakingclock.service.TimeService;

public class TimeServiceTest {
	 @Test
	    public void testConvertToWords_ValidTime_ReturnsExpectedResult() {
	        TimeService timeService = new TimeService();

	        String result = timeService.convertToWords("08:34");

	        Assertions.assertEquals("It's eight thirty four minutes", result);
	    }

	    @Test
	    public void testConvertToWords_Midday_ReturnsExpectedResult() {
	        TimeService timeService = new TimeService();

	        String result = timeService.convertToWords("12:00");

	        Assertions.assertEquals("It's Midday", result);
	    }

	    @Test
	    public void testConvertToWords_Midnight_ReturnsExpectedResult() {
	        TimeService timeService = new TimeService();

	        String result = timeService.convertToWords("00:00");

	        Assertions.assertEquals("It's Midnight", result);
	    }

	    @Test
	    public void testConvertToWords_InvalidTime_ThrowsIllegalArgumentException() {
	        TimeService timeService = new TimeService();

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            timeService.convertToWords("25:00");
	        });
	    }
}
