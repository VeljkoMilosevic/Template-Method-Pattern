package desing.patterns.templatemethod.domain;


public class FileHandlingException extends Exception {


    FileHandlingException() {
        super("Exception during working with file!");
    }

    FileHandlingException(final String message) {
        super(message);
    }

    public FileHandlingException(final String message, final Exception exception) {
        super(message, exception);
    }
}
