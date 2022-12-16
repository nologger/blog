package kim.blog.common.exception;

public class InvalidMarkdownFormatException extends RuntimeException{
    public InvalidMarkdownFormatException(String message) {
        super(message);
    }
}
