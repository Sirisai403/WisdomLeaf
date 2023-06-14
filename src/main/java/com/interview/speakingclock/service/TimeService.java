package com.interview.speakingclock.service;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

	public String convertToWords(String time) {
		String[] parts = time.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);

		if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("Invalid time");
		}

		if (hours == 0 && minutes == 0) {
			return "It's Midnight";
		}

		if (hours == 12 && minutes == 0) {
			return "It's Midday";
		}

		String convertedHours = convertNumberToWords(hours);
		String convertedMinutes = convertNumberToWords(minutes);

		StringBuilder result = new StringBuilder("It's ");
		result.append(convertedHours).append(" ");
		if (minutes != 0) {
			result.append(convertedMinutes).append(" ");
		}
		result.append("minutes");

		return result.toString();
	}

	private String convertNumberToWords(int number) {
		String[] tensNames = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		String[] numNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		if (number == 0) {
			return "zero";
		}

		if (number < 20) {
			return numNames[number];
		}

		StringBuilder result = new StringBuilder();
		result.append(tensNames[number / 10]);
		if (number % 10 != 0) {
			result.append(" ").append(numNames[number % 10]);
		}

		return result.toString();
	}

}
