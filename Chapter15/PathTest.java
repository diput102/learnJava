package Chapter15;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args)throws Exception{
        Path path= Paths.get(".","1");
        System.out.println("路径数量"+path.getNameCount());
        System.out.println("根路径"+path.getRoot());
        Path absolutePath=path.toAbsolutePath();
        System.out.println("绝对路径"+absolutePath);
        System.out.println("绝对路径的路径数量"+absolutePath.getNameCount());
        System.out.println("绝对路径的根路径"+absolutePath.getRoot());
//        System.out.println(absolutePath.getName(3));
        Path path2=Paths.get("m:","publish","codes","aaa");
        System.out.println(path2);
        System.out.println("路径数量"+path2.getNameCount());
        System.out.println("绝对路径的路径数量"+path2.toAbsolutePath().getNameCount());

    }
}
