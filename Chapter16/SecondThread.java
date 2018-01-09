package Chapter16;

public class SecondThread implements Runnable {
    private int i;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20) {
                SecondThread st = new SecondThread();
                new Thread(st, "新线程1").start();
                //sleep在这里 新线程2直接被阻塞
                //main先被阻塞
//                Thread.sleep(10);
                new Thread(st, "新线程2").start();
                Thread.sleep(10);
            }
            //main转入就绪运行
        }
    }

    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
