package es.daumienebi.comicmanagement.utils;
import java.time.DateTimeException;
import java.time.LocalDate;

public class TextFieldValidatorUtil {

	public static boolean isValidDate(int day, int month, int year) {
		//checks if the date format is correct
		boolean valid = false;		
		try {
			LocalDate.of(year, month, day);
			valid = true;
		} catch (DateTimeException ex) {
			valid = false;
		}
		return valid;		
	}
	
	public static boolean isNumeric(String value) {
		//checks if a given value is numeric
		boolean numeric;		
		try {
			int num = Integer.parseInt(value);
			numeric = true;
		}catch(NumberFormatException ex) {
			numeric = false;
		}		
		return numeric;
	}
	
	public static boolean isDouble(String value) {
		//checks if a given value is numeric
		boolean doublee;		
		try {
			double num = Double.parseDouble(value);
			doublee = true;
		}catch(NumberFormatException ex) {
			doublee = false;
		}		
		return doublee;
	}
}
