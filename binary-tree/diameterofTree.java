import java.util.*;

public class diameterofTree{
    static class Node{
        int data ;
        Node left ;
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
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int max = Math.max(leftHeight  ,   rightHeight) + 1;
        return  max;
    }
    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameterOfTree(root.left);
        int diam2 = diameterOfTree(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(diam3, Math.max(diam1, diam2));
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameterOfTree(root));
    }
}