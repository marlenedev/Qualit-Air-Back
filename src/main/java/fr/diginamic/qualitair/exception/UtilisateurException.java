package fr.diginamic.qualitair.exception;

public class UtilisateurException extends RuntimeException {

    public UtilisateurException() {
    }

    public UtilisateurException(String message) {
        super(message);
    }

    public UtilisateurException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilisateurException(Throwable cause) {
        super(cause);
    }

    public UtilisateurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
