package chapter6;

public class InfiniteRecursion {
    String a="chen";
    String b=a+new String("ssy");
    public int  hashCode() {
        return "ssy ".hashCode();
    }

    public static void main(String[] args) {
        InfiniteRecursion ir = new InfiniteRecursion();
        System.out.println(ir);
        System.out.println(ir.hashCode());
    }
}
