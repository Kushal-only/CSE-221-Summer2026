import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args)throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0;j<k;j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][x] = 1;
            }
        }
        for(int p=0;p<n;p++) {
            for(int q=0;q<n;q++) {
                pw.print(arr[p][q] + " ");
            }
            pw.println();
        }
        pw.close();
    }
}
