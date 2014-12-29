package de.steinberg.gyp.core.exception;

/**
 *
 *
 * Created by LKLeen on 10.12.2014.
 */
public abstract class ApplicationException extends RuntimeException {
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message) {
        super(message);
    }
}
