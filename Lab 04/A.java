import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n+1][n+1];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int wgh = Integer.parseInt(st.nextToken());
            arr[src][des] = wgh;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                pw.print(arr[i][j] + " ");
            }
            pw.println();
        }
        pw.close();  
    }
}