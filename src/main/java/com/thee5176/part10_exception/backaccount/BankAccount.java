package com.thee5176.part10_exception.backaccount;

//話題：
public class BankAccount {
    private double amount;           //amount of money
    private String name;             //account holder's name

    public BankAccount(double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    //Setter
    public void setAmount(double amount) throws InsufficientFundException {
        if (amount < 0) {
            throw new InsufficientFundException("残高は0以下の設定できません。");
        } else {
            this.amount = amount;
        }
    }

    //Getter
    public double getAmount() {
        return amount;
    }

    //メッソド
    public void deposit(double amount) throws NegativeInputAmountException, InsufficientFundException {
        //入金金額は0円以上のチェック
        if (amount > 0) {
            double balance = this.getAmount();
            this.setAmount(balance + amount);
            System.out.println(this.getAmount());
        } else {
            throw new NegativeInputAmountException("入金の金高は0以下になっています。");
            // throw new NegativeInputAmountException("入金高が0円以下になっています。");
        }
    }

    ;

    public void withdraw(double amount) throws NegativeInputAmountException, InsufficientFundException {
        //引出金額は0円以上のチェック
        if (amount < 0) {
            throw new NegativeInputAmountException("引出の金高は0以下になっています。");
        }

        //残高チェック
        double checkAmount = this.getAmount() - amount;
        if (checkAmount >= 0) {
            double balance = this.getAmount();
            this.setAmount(balance - amount);
            System.out.println(this.getAmount());
        } else {
            throw new InsufficientFundException("口座の残高は足りません。");
        }
    }

    ;

    public static void main(String[] args) throws InsufficientFundException, NegativeInputAmountException {
        BankAccount myAccount = new BankAccount(1000, "ティー");
        myAccount.deposit(1000);                //2000.0
        myAccount.withdraw(2000);               //0.0

        try {
            myAccount.deposit(-3000);               //Exception line49
        } catch (NegativeInputAmountException e) {
            System.out.println(e.getMessage());
        }
        try {
            myAccount.withdraw(-3000);              //Exception line56
        } catch (NegativeInputAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            myAccount.withdraw(1000);               //Exception line65
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
    }
}
