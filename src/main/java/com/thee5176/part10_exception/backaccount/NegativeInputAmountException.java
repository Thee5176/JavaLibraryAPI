package com.thee5176.part10_exception.backaccount;

public class NegativeInputAmountException extends Exception{
    public NegativeInputAmountException(String m){
        super(m);
    }
}
