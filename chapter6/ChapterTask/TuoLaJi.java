package chapter6.ChapterTask;

import chapter6.ChapterTask.Car;

public class TuoLaJi extends Car {
    private int ChanZiNum;
    public TuoLaJi(int heavy,String use,int ChanZinNum) {
        super(heavy,use);
        this.ChanZiNum=ChanZinNum;
        System.out.println("TuoLaJi has "+heavy+"kg"+use+ChanZiNum+"ChanZi");


    }
    public String getType()
    {
        return "TuoLaJi";
    }


}
