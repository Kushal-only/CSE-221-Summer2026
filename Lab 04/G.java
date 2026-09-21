import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[k];
        int [] arr2 = new int[k];
        int [] x = {-2,-2,-1,-1,1,1,2,2};
        int [] y = {-1,1,-2,2,-2,2,-1,1};
        boolean [][] arr3 = new boolean[n+1][m+1];
        boolean flag = false;
        for(int i=0;i<k;i++) {
            st =  new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            int p = arr1[i];
            int q = arr2[i];
            arr3[p][q] = true; 
        }
        for(int j=0;j<k;j++) {
            if(flag==false) {
            int t = 0;
            while(t<8) {
                int a = arr1[j] + x[t];
                int b = arr2[j] + y[t];
                if(a>=1 && a<=n) {
                    if(b>=1 && b<=m) {
                        if(arr3[a][b]==true) {
                            flag = true;
                            break;
                        }
                    }
                }
                t++;
            }
          }
        }
        if(flag==true) {
            pw.print("YES");
        }
        else {
            pw.print("NO");
        }
        pw.close();
    }
}
