import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int [] arr1 = {-1,-1,-1,0,0,1,1,1};
        int [] arr2 = {-1,0,1,-1,1,-1,0,1};
        int [] x = new int[8];
        int [] y = new int[8];
        int count = 0;
        for(int i=0;i<8;i++) {
            int p = n1+arr1[i];
            int q = n2+arr2[i];
            if(p>=1 && p<=n) {
                if(q>=1 && q<=n) {
                    x[count] = p;
                    y[count] = q;
                    count++;
                }
            }
        }
        pw.println(count);
        for(int j=0;j<count;j++) {
            pw.println(x[j] + " " + y[j]);
        }
        pw.close();
    }
}
