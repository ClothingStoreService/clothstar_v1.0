package org.store.clothstar.order.utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateOrderId {

	private static final String DATE_FORMAT = "yyyyMMdd";
	private static final int RANDOM_NUMBER_LENGTH = 7;
	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	public static Long generateOrderId() {
		String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));

		StringBuilder randomDigits = new StringBuilder();
		for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
			randomDigits.append(SECURE_RANDOM.nextInt(10));
		}

		String orderIdString = datePrefix + randomDigits.toString();

		Long orderId = Long.parseLong(orderIdString);

		return orderId;
	}
}