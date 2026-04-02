import java.util.*;

public class diameterofTreeoptimised{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    static class TreeInfo{
        int height;
        int diameter;
        TreeInfo(int h1, int dia){
            this.height = h1;
            this.diameter = dia;
        }
    }

    public static TreeInfo diameterOfTree(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);

        int myheight = Math.max(left.height, right.height) + 1;
        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;

        int myDiameter = Math.max(diam3, Math.max(diam1, diam2));
        return new TreeInfo(myheight, myDiameter);
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameterOfTree(root).diameter);
    }
}