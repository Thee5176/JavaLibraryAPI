package com.thee5176.part10_exception.filereader;

import java.io.IOException;

public class ProcessingException extends Throwable {
    //https://www.youtube.com/watch?v=vwkqBDjT-UI
    public ProcessingException(String m) { super(m); }

    public ProcessingException(String message, Exception exception) { super(message,exception); }

}
