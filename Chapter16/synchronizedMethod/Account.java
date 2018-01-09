package Chapter16.synchronizedMethod;

public class Account {
    private String accountNo;
    private double balance;
    public Account(){};
    public Account(String accountNo,double balance){
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
    public synchronized void draw(double drawAmount){
        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName()+" 取钱成功！取出"+drawAmount);
            try{
            Thread.sleep(1);}
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
            balance=balance-drawAmount;
            System.out.println(Thread.currentThread().getName()+"账户余额为"+balance);
        }
        else{
            System.out.println(Thread.currentThread().getName()+"取钱失败!");
        }

    }
    public int hashCode(){
        return accountNo.hashCode();
    }
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj!=null&&obj.getClass()==Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(this.accountNo);
        }
        return false;
    }
}
