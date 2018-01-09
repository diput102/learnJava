package Chapter16;

import Chapter16.synchronizedMethod.Account;

import java.util.concurrent.locks.ReentrantLock;

public class LockAccount {
    private final ReentrantLock lock=new ReentrantLock();
    private String accountNo;
    private double balance;
    public LockAccount(){};
    public LockAccount(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }
    public  void draw(double drawAmount){
        lock.lock();
        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + " 取钱成功！取出" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                balance = balance - drawAmount;
                System.out.println(Thread.currentThread().getName() + "账户余额为" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败!");
            }
        }
        finally {
            lock.unlock();
        }

    }
    public int hashCode(){
        return accountNo.hashCode();
    }
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj!=null&&obj.getClass()== Chapter16.synchronizedMethod.Account.class) {
            Chapter16.synchronizedMethod.Account target = (Account) obj;
            return target.getAccountNo().equals(this.accountNo);
        }
        return false;
    }
}
