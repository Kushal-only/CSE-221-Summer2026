import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int [] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] =Integer.parseInt(st.nextToken()); 
        }
        int p = 0;
        int sum = 0;
        int hL = 0;
        int q = 0;
        while(q<l) {
            sum += arr[q];
            while(t<sum) {
                sum -= arr[p];
                p++;
            }
            int cL = q-p+1;
            if(cL>hL) {
                hL = cL;
            }
            q++;
        }
        pw.println(hL);
        pw.close();
    }
}