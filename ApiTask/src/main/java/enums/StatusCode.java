package enums;

public enum StatusCode {
    GET_OK_RESPONSE(200),
    GET_ERROR_RESPONSE(404),
    POST_OK_RESPONSE(201),
    ;
    public int code;

    StatusCode(int code) {
        this.code = code;
    }
}
