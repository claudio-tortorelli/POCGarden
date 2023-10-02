package claudiosoft.pocbase;

/**
 *
 * @author Claudio
 */
public enum ErrorCode {
    OK("0000", "OK"),
    //////// initialization
    INIT_ERROR("0100", "initialization error"),
    //////// steps parsing
    PARSING_ERROR("0200", "parsing error"),
    //////// utility
    UTILITY_ERROR("0300", ""),
    //////// generic
    GENERIC_ERROR("9999", "generic error");

    private String code;
    private String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getCodeMessage() {
        return String.format("%s-%s", code, message);
    }

    public String getCodeMessage(String msg) {
        return String.format("%s-%s", code, msg);
    }

}
