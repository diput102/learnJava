package chapter6.ChapterTask;

interface Funcinter{
    void TrafficAccident();
}
public class Task3 {

    public Task3(int i){
        this.i=i;
    }
    int i;
    public void crash(Funcinter fi){
        if(i==1)
        {
            fi.TrafficAccident();
        }
        else
            System.out.println("safe");
    }
    public static void main(String[] args){
        Task3 t3=new Task3(0);
        t3.crash(new Funcinter() {
            @Override
            public void TrafficAccident() {
                System.out.println("call police");
            }
        });
    }
}
