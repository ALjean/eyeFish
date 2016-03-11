package com.jean;

import java.sql.SQLException;

/**
 * Created by root on 28.06.15.
 */
public class CustomDfmException extends Exception {

    public CustomDfmException() {

    }

    public CustomDfmException(String message) {
        super (message);
    }
    public CustomDfmException(String message, Exception e) {
        super (message, e);
    }

    public CustomDfmException(Throwable cause) {
        super (cause);
    }

    public CustomDfmException(SQLException cause, String message) {
        super (message, cause);
    }
}
