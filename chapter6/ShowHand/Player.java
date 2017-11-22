package chapter6.ShowHand;

public class Player {
    private String name;//定义参赛者的名字
    private String location;//定义参赛者的位置：上下左右
    private boolean flag = true;//定义是否放弃，true为继续，false为放弃,默认值为true
    private String[] pok = new String[5];//定义牌类
    public Player(){}
    public Player(String name,String location){
        this.name = name;
        this.location = location;
    }
    //覆写toString方法
    public String toString(){
        StringBuffer buf = new StringBuffer();
        for(int i=1;i<pok.length;i++){//此处的计数i要从1开始而不是0，因为第一张牌是底牌所以不能显示出来
            buf.append("[").append(pok[i]).append("]");
        }
        return "玩家："+name + "，底牌:"+"["+pok[0]+"]"+"，牌面："+buf.toString();
    }

    public String getInfo(String info){
        return info;
    }

    public boolean getFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getPok() {
        return pok;
    }
    public void setPok(String[] pok) {
        this.pok = pok;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public static void main(String[] args) {

    }
}
