package Chapter16;

public class Account {
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

    public synchronized void draw(double drawAmount) {
        try{
        if (flag == true) {
            System.out.println(Thread.currentThread().getName() + "可以取款" + "取出" + drawAmount);
            balance = balance - drawAmount;
            System.out.println("账户余额"+balance);
            flag = false;
            notify();
        } else {

                this.wait();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    public synchronized void deposit(double dpAmount) {
        if (flag == false) {
            System.out.println(Thread.currentThread().getName() + "请存钱" + " 存入" + dpAmount);
          /*  try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }*/
            balance = balance + dpAmount;
            System.out.println("账户余额"+balance);
            flag = true;
            notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
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
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
