package chapter6.ChapterTask;
interface Task2inter{
    public  String TuoLaJi2();
    public  String KaChe2();
}
public class Task2 {
    public void test(Task2inter t){
        System.out.println("There are many Car ,for example num 1:"+t.TuoLaJi2()+" num 2"+t.KaChe2());
    }
    public static void main(String[] args)
    {
        Task2 t2=new Task2();
        t2.test(new Task2inter(){
            public  String TuoLaJi2() {
            return "TuoLaJi is use to ChanDi";
        }
        public  String KaChe2(){
                return "KaCheis use to load";
    }
    });
    }

}
