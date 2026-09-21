import java.io.*;
import java.util.*;

public class H {
    public static int gcd(int x,int y) {
        while(y!=0) {
            int t = y;
            y = x%y;
            x = t;
        }
        return x;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int qry = Integer.parseInt(st.nextToken());
        int [] count = new int[n+1];
        int [][] arr = new int[n+1][n];
        for(int i=1;i<=n;i++) {
            int u = 0;
            int j = 1;
            while(j<=n) {
                if(j!=i) {
                    int g  = gcd(i,j);
                    if(g==1) {
                        arr[i][u] = j;
                        u++;
                    }
                }
                j++;
            }
            count[i] = u;
        }
        for(int q=0;q<qry;q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(k<=count[x]) {
                pw.println(arr[x][k-1]);
            }
            else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}
