package com.jean;

import java.sql.SQLException;

public class DaoDfmException extends Exception {

    public DaoDfmException() {

    }

    public DaoDfmException(String message) {
        super(message);
    }

    public DaoDfmException(String message, Exception e) {
        super(message, e);
    }

    public DaoDfmException(Throwable cause) {
        super(cause);
    }

    public DaoDfmException(String message, SQLException cause) {
        super(message, cause);
    }
}
