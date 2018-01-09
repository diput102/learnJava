package Chapter16;

class Account9{
    ThreadLocal<String> name=new ThreadLocal<>();
    public Account9(String str){
        this.name.set(str);
        System.out.println("----"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}
class MyTest extends Thread{
    private Account9 account;
    public MyTest(Account9 account,String name){
        super(name);
        this.account=account;
    }
    public void run(){
        for(int i=0;i<10;i++){
            if(i==6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户i的值"+i);
        }
    }
}
public class ThreadLocalTest {
    public static void main(String[] args) {
        Account9 at = new Account9("初始名");
        new MyTest(at, "线程甲").start();
        new MyTest(at,"线程乙").start();
    }
}
