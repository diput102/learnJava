package Chapter16.Test2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class CarIn extends Thread {
    private BlockingQueue<String> bq;
    private String CarNo;

    public CarIn(BlockingQueue<String> bq, String CarNo) {
        this.bq = bq;
        this.CarNo = CarNo;
    }

    public void run() {
        System.out.println("可以停车");
        try {
            bq.put(CarNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("车牌号为" + CarNo);
    }

}

class CarOut extends Thread {
    private BlockingQueue<String> bq;
    private String CarNo;

    public CarOut(BlockingQueue<String> bq, String CarNo) {
        this.bq = bq;
        this.CarNo = CarNo;
    }

    public void run() {
        try {
            bq.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("车牌号" + CarNo + "已离开");
    }

}

public class Park {
    public static void main(String[] args) {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        new CarIn(bq, "001").start();
        new CarIn(bq, "002").start();
        new CarOut(bq, "001").start();
    }
}