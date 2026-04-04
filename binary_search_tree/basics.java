import java.util.*;

public class basic{
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
    static class BinarySearchTree{
        public static Node insert(Node root, int val){
            if(root == null){
                return new Node(val);
            }
            if(val < root.data){
                root.left = insert(root.left, val);
            }else{
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static Node buildBST(int values[]){
            Node root = null;
            for(int val : values){
                root = insert(root, val);
            }
            return root;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        BinarySearchTree tree = new BinarySearchTree();
        Node root = tree.buildBST(values);
        System.out.println(root.data);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
    }
}