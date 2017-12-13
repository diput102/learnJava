package Chapter15;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
    public static void main(String[] args)throws Exception{
        Files.walkFileTree(Paths.get("F:","Jtest"),new SimpleFileVisitor<Path>()
        {
            //访问文件时触发该方法
            @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException{
            System.out.println("正在访问"+file+"文件");
            //找到了FileVisitorTest.java文件
            if(file.endsWith("FileVisitorTest.java")){
                System.out.println("--已找到--");
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }
        //开始访问目录时触发该文件
        @Override
                public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs)throws IOException{
            System.out.println("正在访问"+dir+"路径");
            return FileVisitResult.CONTINUE;
        }

        });

    }

}
