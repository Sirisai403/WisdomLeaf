package com.interview.speakingclock.contoller.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.interview.speakingclock.controller.TimeController;
import com.interview.speakingclock.service.TimeService;

public class TimeControllerTest {
	@Mock
	private TimeService timeService;

	@InjectMocks
	private TimeController timeController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testConvertTime_ValidTime_ReturnsConvertedTime() {
		String inputTime = "08:34";
		String convertedTime = "It's eight thirty-four minutes";

		when(timeService.convertToWords(inputTime)).thenReturn(convertedTime);

		ResponseEntity<String> response = timeController.convertTime(inputTime);

		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(convertedTime, response.getBody());

		verify(timeService, times(1)).convertToWords(inputTime);
		verifyNoMoreInteractions(timeService);
	}

	@Test
	public void testConvertTime_InvalidTime_ReturnsBadRequest() {
		String inputTime = "25:00";
		String errorMessage = "Invalid time";

		when(timeService.convertToWords(inputTime)).thenThrow(new IllegalArgumentException(errorMessage));

		ResponseEntity<String> response = timeController.convertTime(inputTime);

		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		Assertions.assertEquals(errorMessage, response.getBody());

		verify(timeService, times(1)).convertToWords(inputTime);
		verifyNoMoreInteractions(timeService);
	}
}
