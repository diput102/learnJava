package chapter6.ChapterTask;

public class KaChe extends Car {
    private int load;
    public KaChe(int heavy,String use,int load){
        super(heavy,use);
        this.load=load;
        System.out.println("KaChe has"+heavy+"kg"+use+"it can load"+load+"kg");
    }
    public String getType()
    {
        return "KaChe";
    }
    public static void main(String[] args)
    {
        Car c1=new TuoLaJi(50,"wa di",3);
        Car c2=new KaChe(40,"tuo yun",20);
        System.out.println(c1.getType());
        System.out.println( c1.getWheelRadius());
    }
}
