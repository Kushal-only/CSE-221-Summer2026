import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long mod = Long.parseLong(st.nextToken());
            long [] ans = sum(x,y,mod);
            pw.println(ans[0]);
        } 
        pw.close();
    }
    public static long[] sum(long x,long y,long mod) {
        if(y==0) {
            long [] arr = {0,1};
            return arr;
        }
        long [] arr2 = sum(x,y/2,mod);
        long u = (1+arr2[1])%mod;
        long v = (arr2[0]*u)%mod;
        long p = (arr2[1]*arr2[1])%mod;
        if(y%2!=0) {
            p = (p*x)%mod;
            v = (v+p)%mod;
        }
        long [] res = {v,p};
        return res;
    }
}
