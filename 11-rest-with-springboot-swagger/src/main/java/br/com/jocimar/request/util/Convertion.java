package br.com.jocimar.request.util;

public class Convertion {
	
	public static final Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;

		if (!Validation.isNumeric(strNumber))
			return 0D;

		String number = strNumber.replaceAll(",", ".");
		return Double.parseDouble(number);
	}
}
