package Chapter17;

public class MultiThreadDown {
    public static void main(String[] args)throws Exception{
        final DownUtil downUtil=new DownUtil("https://upload-1253442168.file.myqcloud.com/apk/app-web-release_legu_signed_zipalign-301.apk"
                , "t1.apk" , 4);
        downUtil.download();
        new Thread(()->{
            while(downUtil.getCompleteRate()<=1){
                //每隔0.1秒查询一次任务的完成进度
                //GUI程序可根据该进度来绘制进度条
                System.out.println("已完成"+downUtil.getCompleteRate());
                try{
                    Thread.sleep(1000);
                }
                catch (Exception ex){}
            }
        }).start();
    }
}
