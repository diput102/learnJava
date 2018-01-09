package Chapter16.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void draw(double drawAmount) {
        try {
            lock.lock();
            if (flag == true) {
                System.out.println(Thread.currentThread().getName() + "可以取款" + "取出" + drawAmount);
                balance = balance - drawAmount;
                System.out.println("账户余额" + balance);
                flag = false;
                cond.signal();
            } else {

                cond.await();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    public synchronized void deposit(double dpAmount) {
        try {
            lock.lock();

            if (flag == false) {
                System.out.println(Thread.currentThread().getName() + "请存钱" + " 存入" + dpAmount);
          /*  try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }*/
                balance = balance + dpAmount;
                System.out.println("账户余额" + balance);
                flag = true;
                cond.signal();
            } else {

                cond.await();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }


    public double getBalance() {
        return balance;
    }

    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Chapter16.Account.class) {
            Chapter16.Account target = (Chapter16.Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
