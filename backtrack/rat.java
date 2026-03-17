

public class rat{
    public static int ratways(int i , int j , int n, int m, boolean[][] visited){
        if(i == n-1 && j == m-1){
            return 1;
        }else  if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int w1 = ratways(i+1, j , n , m,visited);
        int w2 = ratways(i , j+1, n , m,visited);
        int w3 = ratways(i-1, j, n ,m,visited);
        int w4 = ratways(i , j-1, n, m,visited);
        visited[i][j] = false;
        return w1+w2+w3+w4;

    }
    public static void main(String[] args){
        int n = 3;
        int m  =3;
        boolean[][] visited = new boolean[n][m];
        System.out.println("total no. of ways: " + ratways(0,0,n, m,visited));


    }
}