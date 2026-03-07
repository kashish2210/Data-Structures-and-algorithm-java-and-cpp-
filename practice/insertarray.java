import java.util.*;
public class insertarray {
    public static void printarray(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void print2darray(int[][] matrix){
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void reverse_from_position(int[] arr , int position){
        if (arr == null || position < 0 || position >= arr.length) {
            return;
        }
        int left = position;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void reverse_using_collections(int[] arr){
        if (arr == null) {
            return;
        }
        Integer[] boxed = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxed[i] = arr[i];
        }
        Collections.reverse(Arrays.asList(boxed));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
    }
    public static int sumAscii(String str) {
        int sum = 0;
        String inputString = str.toLowerCase();

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            int asciiValue = (int) character;
            sum += asciiValue;
            System.out.println("Character: " + character + " | ASCII Value: " + asciiValue);
        }

        System.out.println("Sum of ASCII values: " + sum);
        return sum;
    }
    public static void digitsSum(int num) {
        int sum = 0;
        int n = num;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        System.out.println("Sum of digits of ASCII sum: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // System.out.println("enter the position u want to enter the number in the array (0-n)");
        // int position = sc.nextInt();
        // System.out.println("enter the element u want to enter the postion "+ position + " in the array");
        // arr[position] = sc.nextInt();
        System.out.println("enter the elements of the array from (0-n)");
        for(int i = 0 ; i< n ;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("your array is : ");
        printarray(arr);
        System.out.println("enter the position from u want reverse array: ");
        int pos = sc.nextInt();
        reverse_from_position(arr,pos);
        System.out.println("your reversed array from "+pos+ " is : ");
        printarray(arr);
        
    }
}

