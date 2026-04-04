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
    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(key == root.data){
            return true;
        }
        if(key < root.data){
            return search(root.left , key);
        }else{
            return search(root.right , key);
        }
    }
    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        BinarySearchTree tree = new BinarySearchTree();
        Node root = tree.buildBST(values);
        int key = 15;
        System.out.println(search(root , key));
    }
}