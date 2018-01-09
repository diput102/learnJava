package Chapter16.synchronizedMethod;

public class DrawThread extends Thread{
    Account account;
    double drawAmount;
    public DrawThread(String name,Account accout,double drawAmount){
        super(name);
        this.account=accout;
        this.drawAmount=drawAmount;
    }
    public void run()
    {
       account.draw(drawAmount);
    }

}
