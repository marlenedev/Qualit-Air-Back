package fr.diginamic.qualitair.exception;

/**
 * Exception en cas d'erreur lors de la création d'un thème
 *
 */
public class CreerDiscussionException extends RuntimeException {

	public CreerDiscussionException() {
	}

	public CreerDiscussionException(String message) {
		super(message);
	}

	public CreerDiscussionException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreerDiscussionException(Throwable cause) {
		super(cause);
	}

	public CreerDiscussionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}