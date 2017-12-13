package Chapter15;

import java.io.IOException;
import java.io.PrintStream;

public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        //运行java ReadStandard命令，返回运行该命令的子进程
        Process p1 = Runtime.getRuntime().exec("javac ReadStandard");
        try (PrintStream ps = new PrintStream(p1.getOutputStream())) {
            ps.println("testttttt");
            ps.println(new WriteToProcess());
        } catch (Exception e) {
            System.out.println("fuck");
        }

    }
}
