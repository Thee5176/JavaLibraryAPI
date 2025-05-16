package com.thee5176.part10_exception.backaccount;

public class InsufficientFundException extends Exception{
    //https://www.geeksforgeeks.org/user-defined-custom-exception-in-java/
    public InsufficientFundException(String m){
        super(m);
    }
}
