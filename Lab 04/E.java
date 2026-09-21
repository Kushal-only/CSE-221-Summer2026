import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[m];
        int [] arr2 = new int[m];
        int [] in = new int[n+1];
        int [] out  = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<m;j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }
        for(int k=0;k<m;k++) {
            int x = arr1[k];
            int y = arr2[k];
            out[x]++;
            in[y]++;
        } 
        for(int p=1;p<=n;p++) {
            int q = in[p]-out[p];
            pw.print(q + " ");
        }
        pw.close();
    }
}
