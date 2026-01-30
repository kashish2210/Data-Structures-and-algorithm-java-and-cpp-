import java.util.*;

public class pattern{
    public static void main(String args[]){
        System.out.println(" Enter Size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println();
        System.out.println(" rigth triangele");
        System.out.println();
        for(int i  = 0 ; i < size; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" inverted triangele");
        System.out.println();
        for(int i  = size ; i >= 0; i--){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" reverse right triangele");
        System.out.println();
        for(int i = 0 ; i < size; i++){
            for(int j = size -1 ; j > i ; j--){
                System.out.print("  ");
            }
            for(int j = 0 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("equilateral triangele");
        System.out.println();
        for(int i = 0 ; i < size; i++){
            for(int j = size -1 ; j > i ; j--){
                System.out.print(" ");
            }
            for(int j = 0 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" reverse equilateral triangele");
        System.out.println();
        for(int i = size ; i>=0; i--){
            for(int j = size  ; j > i ; j--){
                System.out.print(" ");
            }
            for(int j = 0 ; j <= i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" numbers pyramid");
        System.out.println();
        for(int i  = 0 ; i < size; i++){
            int num = 1;
            for(int j = 0 ; j <= i ; j++){
                System.out.print(" "+num);
                num++;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" Diamond:)");
        System.out.println();
        for(int i = 0 ; i < size/2 ; i++){
			for(int j = size/2 ; j > i ; j--){
				System.out.print(" ");
			}
			for(int j = 0 ; j <= i; j++){
				System.out.print("# ");
			}
            System.out.println();
        }
        for(int i = 0 ; i <= size/2;i++){
            System.out.print("# ");
        }
        System.out.println();
        for(int i = 0 ; i < size/2 ; i++){
			for(int j = 0 ; j <= i; j++){
				System.out.print(" ");
			}
            for(int j = size/2 ; j > i ; j--){
				System.out.print("# ");
			}
            System.out.println();
        }
        System.out.println();
        System.out.println(" numbera pyramid 2");
        System.out.println();
        int num = 1;
        for(int i  = 0 ; i < size; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(" "+num);
                num++;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" numbera pyramid 3");
        System.out.println();
        int num1 = 1;
        for(int i  = 0 ; i < size; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(" "+num1);
            }
            System.out.println();
            num1++;
        }
        System.out.println();
        System.out.println(" Butterfly");
        System.out.println();
        for(int i = 1 ; i <= size ; i++){
            //stars i
            for(int l =1 ; l <= i; l++){
                System.out.print("*");
            }
            // spaces 2*(n-1)i
            for(int k = 1 ; k <= 2*(size -i); k++){
                System.out.print(" ");
            }
            //stars i
            for(int j =1;j <= i; j++){
                System.out.print("*");
            }
         System.out.println();
        }
        for(int i = size ; i >= 1 ; i--){
            //stars i
            for(int l =1 ; l <= i; l++){
                System.out.print("*");
            }
            // spaces 2*(n-1)i
            for(int k = 1 ; k <= 2*(size -i); k++){
                System.out.print(" ");
            }
            //stars i
            for(int j =1;j <= i; j++){
                System.out.print("*");
            }
         System.out.println();
        }
    }
}