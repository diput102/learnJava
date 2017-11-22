package chapter6.ShowHand;

/**
 * 项目需求：
 * 此类是一个梭哈游戏，这个类应该包含桌上剩下的牌的信息，
 * 并包含5个玩家的状态信息：
 * ----他们各自的位置、
 * ----游戏的状态（正在游戏或已放弃）、
 * ----手上已有的牌等信息。
 * 如果有可能，这个类还应该实现发牌方法：
 * ----这个方法需要控制从谁开始发牌，
 * ----不要发牌给放弃的人，
 * ----并修改桌上剩下的牌。
 *
 * 游戏分析：
 * 需要设计如下几个类：
 * 1、主面板类：MainTable
 *        能够循环生成主面板，每次有状态更新就刷新面板
 * 2、玩家类：Player
 *        此类应该包含如下的成员
 *            Field：名称、位置、游戏状态、牌信息
 *            方法()：选择()、
 *
 * 3、扑克牌类：Poker
 *        此类应该是一个枚举类，应该包含如下的成员：
 *            Field：牌（包含点数和花色）
 * 4、操作类：Operate
 *        此类是一个操作类，此类应该包含如下成员
 *            方法：发牌方法、判断输赢的方法、
 *
 * 设计思路：
 * MainTable类的设计思路应该是这样的：
 * 在面板出来之后，我们应该是使用手动
 * 输入数字0来控制发牌，发第一轮，底牌
 * 发第二轮第一张明牌，这个时候弹出选择面板
 * 从右边的选手开始，选1则跟进游戏，选2则不跟
 * 这个时候后台中应该有一个方法来设置选手们的flag参数
 * 如果flag=true则发牌给他，如果flag=fals，则不发牌
 * 这个会在sendPoker方法中有体现
 * 当游戏到达第五轮的时候，到了最终局，
 * 这一局中，我们要将所有个选手的牌全部都显示出来
 * 同时还要通过一个方法来判断输赢，
 * 不过由于判断的方法过于复杂，
 * 因此我们只输出结果，游戏结束，而不判断输赢。
 *
 * 项目总结：
 * --运行环境JDK1.6
 * 说明：目前，这个游戏可以完成以下请求:
 *      输出主面板，输出玩家的名称，底牌，牌面
 *      按0发牌，底牌和第一张明牌不需要玩家选择跟或不跟
 *      从第二张明牌开始，按0发牌后，会弹出选择按钮
 *      跟就按1，不跟就按2
 *      当发满第五轮的时候，游戏结束，根据牌面判断输赢。
 * 未完成的部分：
 *      1、避免重复发牌的方法
 *      2、判断输赢的方法
 *
 *
 *
 * */

public class MainTable {

    public MainTable(){
        init();
        while(true){
            goGame();
        }
    }

    private static Player boss = new Player();//定义发牌者，它的牌就是剩下的牌
    /**
     * 我定义了四个玩家的座位，这四个座位的位置是固定的，
     * 而位置上的人，也就是Name属性是可以变动，
     * 修改四个Player的Name Field 就可以做到改变人物位置的效果
     * */
    private static Player shang = new Player();//定义位置在上面的玩家shang，
    private static Player xia = new Player();//定义位置在下面的玩家xia，
    private static Player left = new Player();//定义位置在左边的玩家left，
    private static Player right = new Player();//定义位置在右边的玩家right，

    private static String[] total = Poker.poker;//此数组中保存了所有的牌共计52张
    private int count = 0;//记录发牌轮数，每过一轮加1
    private static String info = "等待游戏开始";
    /**
     * 定义主面板
     * */
    public static void getTable(){
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t\t\t                                "+shang);
        System.out.println("\t\t\t\t\t\t\t  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.print(left);
        System.out.println("\t ■                          "+boss.getInfo(info)+"\t\t\t\t\t     ■ "+right);
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t ■                                                                           ■ ");
        System.out.println("\t\t\t\t\t\t\t  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("\t\t\t\t\t\t\t                                 "+xia);

        System.out.println("\t\t请输入数字0，开始游戏");
    }

    /**
     * 定义一个5个大小的数组用来保存用户的牌面，
     * 用52个大小的数组来保存发牌者的牌面，
     * 玩家没有牌，发牌这52张牌
     * 同时定义4个玩家的状态值是跟进（true）还是退出（false），
     * 采用boolean值，默认值为跟进（true）
     * 初始化姓名，这里的姓名可以自定义，如果想换位置
     * 那么只接将名称改掉就可以了
     * */
    public static void init(){
        boss.setName("boss");
        shang.setName("shang");
        xia.setName("xia");
        left.setName("left");
        right.setName("right");

        boss.setFlag(true);
        shang.setFlag(true);
        xia.setFlag(true);
        left.setFlag(true);
        right.setFlag(true);

        //对用户的数组进行初始化
        boss.setPok(total);
        shang.setPok(new String[5]);
        xia.setPok(new String[5]);
        left.setPok(new String[5]);
        right.setPok(new String[5]);

    }
    //发牌方法
    String[] bossPoker = null;
    String[] shangPoker = null;
    String[] xiaPoker = null;
    String[] leftPoker = null;
    String[] rightPoker = null;

    public void sendPoker(){
        bossPoker = boss.getPok();
        shangPoker = shang.getPok();
        xiaPoker = xia.getPok();
        leftPoker = left.getPok();
        rightPoker = right.getPok();
        if(count==0){//表明是第一次发牌，则此牌是底牌，不能被显示出来,采用随机数发牌
            /**
             * 此方法对各个玩家发底牌，发底牌为随机发牌，
             *  但是在发牌之前，先检查bossPoker中的该元素是否为null，
             *  如果为null则表明这张牌已经发出，不能再发，
             *  那么就递归调用此方法，直到要发的牌不为null，
             *  则将把这张牌给玩家，然后将此牌设为null，表明已发，
             *  同时将发牌轮数加1
             *  目前，为了节约时间，我并未设置检查牌重复这个方法，
             *  所以发的牌是会存在重复的。
             *
             * */
            int t1 =  (int)(Math.random()*52.0);
            int t2 =  (int)(Math.random()*52.0);
            int t3 =  (int)(Math.random()*52.0);
            int t4 =  (int)(Math.random()*52.0);
            shangPoker[0] = bossPoker[t1];
            xiaPoker[0] = bossPoker[t2];
            leftPoker[0] = bossPoker[t3];
            rightPoker[0] = bossPoker[t4];
            count++;
        }
        //如果轮数等于5，则游戏结束
        if(count==5){
            info = "游戏结束";
            gameOver();//此处应调用方法gameOver
        }
        if(shang.getFlag()){
            shangPoker[count] = checkPoker((int)(Math.random()*52.0));
        }
        if(xia.getFlag()){
            xiaPoker[count] = checkPoker((int)(Math.random()*52.0));
        }
        if(left.getFlag()){
            leftPoker[count] = checkPoker((int)(Math.random()*52.0));
        }
        if(right.getFlag()){
            rightPoker[count] = checkPoker((int)(Math.random()*52.0));
        }
        count++;
    }
    /**
     * 此方法用于判断随机牌是不是曾经发过，
     * 如果此牌发过，则将牌面重新随机一次
     * 由于实现的方法较为复杂，暂时就直接给出
     * 不用判断是否已经出过。
     * */
    public String checkPoker(int t){
        return bossPoker[t];
    }

    /**
     * 定义游戏开始的主要方法，
     * 先绘制面板
     * 初始化
     * 发第一张底牌
     * 发第二张牌
     * */
    public void goGame(){
        getTable();
        Operate op = new Operate();//实例化操作类，使的可以接收键盘的输入
        int temp = op.getZero("输入数字0开始发牌:", "输入错误，请重新输入:");//获取键盘输入的数据，此数据用于判断选择哪个操作
        if(count==5){
            gameOver();
        }
        if(temp==0&&count==0){
            info = "游戏正在进行中";
            sendPoker();//开始发牌
        }
        else{
            checkPlayer();//检查玩家状态，不跟的不发牌
            sendPoker();//开始发牌
        }

    }
    //定义游戏结束的方法
    public void gameOver(){
        info = "游戏结束！";
        getTable();
        System.out.println("游戏结束！");
        System.exit(0);//退出游戏
    }
    /**
     * 这个方法用来判断玩家的状态，分为跟进(true),不跟(false)
     * 跟进就发牌，不跟就不发牌
     * */
    public void checkPlayer(){
        Operate op = new Operate();//实例化操作类，使的可以接收键盘的输入
        int t1 = op.getOneTwo("玩家："+shang.getName()+"跟进按1，不跟按2:", "输入错误，请重新输入:");//获取键盘输入的数据，此数据用于判断选择哪个操作
        if(t1==1){
            shang.setFlag(true);
        }else if(t1==2){
            shang.setFlag(false);
        }else{
            System.out.println("输入错误，请重新输入，");

        }

        int t2 = op.getOneTwo("玩家："+xia.getName()+"跟进按1，不跟按2:", "输入错误，请重新输入:");//获取键盘输入的数据，此数据用于判断选择哪个操作
        if(t2==1){
            xia.setFlag(true);
        }else if(t2==2){
            xia.setFlag(false);
        }else{
            System.out.println("输入错误，请重新输入，");
        }

        int t3 = op.getOneTwo("玩家："+left.getName()+"跟进按1，不跟按2:", "输入错误，请重新输入:");//获取键盘输入的数据，此数据用于判断选择哪个操作
        if(t3==1){
            left.setFlag(true);
        }else if(t3==2){
            left.setFlag(false);
        }else{
            System.out.println("输入错误，请重新输入，");
        }

        int t4 = op.getOneTwo("玩家："+right.getName()+"跟进按1，不跟按2:", "输入错误，请重新输入:");//获取键盘输入的数据，此数据用于判断选择哪个操作
        if(t4==1){
            right.setFlag(true);
        }else if(t4==2){
            right.setFlag(false);
        }else{
            System.out.println("输入错误，请重新输入，");
        }
    }

}