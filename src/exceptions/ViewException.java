package exceptions;

@SuppressWarnings("serial")
public class ViewException extends Exception{
	public static String NULL_VALUES = "You must fill all the blanks.";
	public static String TELEPHONE_IS_NOT_INT = "Telephone must be a number.";
	public static String NO_VALID_VALUES = "Some values are not valid.";
	public ViewException(String msg) {
		super(msg);
	}
}
