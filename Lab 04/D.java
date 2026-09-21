import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[m];
        int [] arr2 = new int[m];
        int [] deg = new int[n+1];
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<m;j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }
        for(int k=0;k<m;k++) {
            int p = arr1[k];
            int q = arr2[k];
            deg[p]++;
            deg[q]++;
        }
        for(int x=1;x<=n;x++) {
            if(deg[x]%2!=0) {
                count++;
            }
        }
        if(count==0 || count==2) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }
        pw.close();
    }
}
