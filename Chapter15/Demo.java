package Chapter15;


import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;

public class Demo {

    //将一个文件夹复制到另一个文件夹
    public static void main(String[] args) throws Exception{
        File dir1 = new File("F://test1");
        File dir2 = new File("F://test4");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //用字节输入输出流
        File[] file = dir1.listFiles();
        for(int i=0;i<file.length;i++){
            String path = file[i].getAbsolutePath();
            String filename = path.substring(path.lastIndexOf("\\")+1, path.length());
            File AfterFile = new File(dir2.toString()+filename+"");
            if(!AfterFile.exists()){
                AfterFile.createNewFile();
            }//如果文件不存在，则进行创建
            System.out.println(path);
            fis = new FileInputStream(file[i]);
            fos = new FileOutputStream(AfterFile);
            byte[] buffer = new byte[1024];
            int length;
            while((length=fis.read(buffer))!=-1){
                fos.write(buffer,0,length);
            }
        }
        fis.close();
        fos.close();
    }
}
