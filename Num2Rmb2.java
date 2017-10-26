import java.util.Arrays;

public class Num2Rmb2 {
    private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private String[] unitArr = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟"};

    //将浮点数乘以100取整
    private String change(double num) {
        long zheng = (long) (num * 100);

        return String.valueOf(zheng);//这里你就已经用了最简单的转string方法，+"",但是你这里先是调用了String.valueOf()已经转成string,没必要再+""
    }

    //将整数化成人民币汉字形式、、你大爷，我问你HanStr的输入参数是什么类型，你说数组，这里输入是一个string，输出也是string
    private String toHanStr(String numStr) {
        String result = "";
        int numLen = numStr.length();
        int count=0;
        for (int i = 0; i < numLen; i++) {
            int num = numStr.charAt(i) - 48;
            //如果不是零 则添加单位
            if (num != 0) {
                result += hanArr[num] + unitArr[numLen - 1 - i];
                count=num;
            }
            //如果最后一位是零 则不读“分”位
            else if (i == numLen - 1 && num == 0) {

            }
            //若num等于0 则判断是否输出圆
            else if ((numLen - 1 - i)%4==2 && (numLen - 1 - i)/2==1) {
                result += unitArr[numLen - 1 - i];
                count=num;
            }
            //判断是否是输出万
            else if ((numLen - 1 - i)%4==2&&count!=0) {
                result += unitArr[numLen - 1 - i]+hanArr[num];//当num=0且为万位时，若前一位不为零，则输出“零”
                count=num;
            }
            else if(count!=0)
            {
                result+=hanArr[num];//当num=0时，若前一位不为零，则输出“零”
                count=num;
            }
            else{
                count=num;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Num2Rmb2 nr2 = new Num2Rmb2();
        String m = nr2.change(200010.613);
        System.out.println(nr2.toHanStr(m));
    }
}
