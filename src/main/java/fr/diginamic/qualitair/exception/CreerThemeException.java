package fr.diginamic.qualitair.exception;

/**
 * Exception en cas d'erreur lors de la création d'un thème
 *
 */
public class CreerThemeException extends RuntimeException {

	public CreerThemeException() {
	}

	public CreerThemeException(String message) {
		super(message);
	}

	public CreerThemeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreerThemeException(Throwable cause) {
		super(cause);
	}

	public CreerThemeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}