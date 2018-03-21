package DataStructures.TreePoint;

import java.util.LinkedList;
import java.util.Queue;

public class TreePoint {
    public static void printTreeValue(BinaryTree root){
        Queue<BinaryTree> queue=new LinkedList<BinaryTree>();
        BinaryTree last;
        BinaryTree nlast=null;
        last=root;
        queue.add(root);
        while(queue.size()>0){
            BinaryTree nowTree=queue.poll();
            if(nowTree.hasLeftNode()){
                queue.add(nowTree.getLeftNode());
                nlast=nowTree.getLeftNode();
            }
            if(nowTree.hasRightNode()){
                queue.add(nowTree.getRightNode());
                nlast=nowTree.getRightNode();
            }
            System.out.print(" "+nowTree.getValue());
            if(last.equals(nowTree)){
                System.out.println();
                last=nlast;
            }
        }
    }
    public static void main(String[] args){
        BinaryTree root=new BinaryTree();
        root.setValue("root");
        BinaryTree left01=new BinaryTree("left01");
        BinaryTree right01=new BinaryTree("right01");
        root.setLeftNode(left01);
        root.setRightNode(right01);
        BinaryTree left11=new BinaryTree("left11");
        BinaryTree right11=new BinaryTree("right11");
        left01.setLeftNode(left11);
        left01.setRightNode(right11);
        printTreeValue(root);

    }
    static class BinaryTree {

        private String value;
        private BinaryTree LeftNode;
        private BinaryTree RightNode;

        public BinaryTree(){

        }

        public BinaryTree(String Value){
            this.value=Value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public BinaryTree getLeftNode() {
            return LeftNode;
        }

        public void setLeftNode(BinaryTree leftNode) {
            LeftNode = leftNode;
        }

        public BinaryTree getRightNode() {
            return RightNode;
        }

        public void setRightNode(BinaryTree rightNode) {
            RightNode = rightNode;
        }

        public boolean hasLeftNode() {
            if (this.LeftNode == null || this.LeftNode.getValue() == null) {
                return false;
            }
            return true;
        }
            public boolean hasRightNode() {
                if(this.RightNode==null||this.RightNode.getValue()==null){
                    return false;
                }
                return true;
        }
    }


}
