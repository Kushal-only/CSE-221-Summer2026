import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            long [] arr = new long[4];  
            st = new StringTokenizer(br.readLine());
            arr[0] = Long.parseLong(st.nextToken());
            arr[1] = Long.parseLong(st.nextToken());
            arr[2] = Long.parseLong(st.nextToken());
            arr[3] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long [] res = power(arr,p);
            pw.println(res[0] + " " + res[1]);
            pw.println(res[2] + " " + res[3]);
        }
        pw.close();
    }
    static long mod = (long)Math.pow(10,9)+7;
    public static long [] power(long [] arr,int p) {
        if(p==0) {
            long [] f = {1,0,0,1};
            return f;
        } 
        long [] arr2 = power(arr,p/2);
        long [] arr3 = new long[4];
        arr3[0] = (arr2[0]*arr2[0] + arr2[1]*arr2[2])%mod;
        arr3[1] = (arr2[0]*arr2[1] + arr2[1]*arr2[3])%mod;
        arr3[2] = (arr2[2]*arr2[0] + arr2[3]*arr2[2])%mod;
        arr3[3] = (arr2[2]*arr2[1] + arr2[3]*arr2[3])%mod;
        if(p%2!=0) {
            long [] arr4 = new long[4];
            arr4[0] = (arr3[0]*arr[0] + arr3[1]*arr[2])%mod;
            arr4[1] = (arr3[0]*arr[1] + arr3[1]*arr[3])%mod;
            arr4[2] = (arr3[2]*arr[0] + arr3[3]*arr[2])%mod;
            arr4[3] = (arr3[2]*arr[1] + arr3[3]*arr[3])%mod;
            return arr4;
        }
        else {
            return arr3;
        }
    }
}
