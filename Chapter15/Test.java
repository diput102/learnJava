package Chapter15;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Test {
    public static void main(String[] args)throws Exception{
        //第一题：输入一个路径，该工具类会把该路径下（及其子目录下）所有文件列出来
        //遍历F：\Jtest目录下（及子目录）所有文件

        Files.walkFileTree(Paths.get("F:","Jtest"),new SimpleFileVisitor<Path>()
                {
                    int countFile=0;
                    int countDir=0;

                    //访问文件时触发该方法
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("正在访问"+file+"文件");
                        countFile++;
                        return FileVisitResult.CONTINUE;
                    }
                    public void getcountFile(){
                        System.out.println(countFile);
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs)throws IOException{
                        System.out.println("正在访问"+dir+"目录---------------------------------");

                        return FileVisitResult.CONTINUE;
                    }

                    //                    @Override
//                    public FileVisitResult postVisitDirectory(Path dir,IOException exc)throws IOException{
//
//
//                            return FileVisitResult.CONTINUE;
//                    }
        }
        );
        //方法二：
        //使用Java8新增的Stream API列出当前目录下所有文件和子目录
        Files.list(Paths.get("F:","Jtest")).forEach(path-> System.out.println(path));
        //第二题:输出该目录下文件数量
        //方法三：
        //指定路径方法
        File file=new File("D:",".");
        String[] fileList=file.list();
        int count=0;
        for(String f:fileList){
            System.out.println(f);
            count++;
        }
        System.out.println(count);



    }
}
