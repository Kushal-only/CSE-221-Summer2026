import java.io.*;
import java.util.*;

public class F {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int [] par = new int[n+1];
        int [] r = new int[n+1];
        for(int i=0;i<=n;i++) {
            par[i] = i;
        }
        for(int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            set(src,des,par,r);
        }
        int k = 0;
     while(k<q) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n1 = find(a,par,r);
            int n2 = find(b,par,r);
            if(n1==n2) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }
            k++;
        }
        pw.close();
    }
        public static void set(int src,int des,int [] par,int [] r) {
            int a1 = find(src,par,r);
            int a2 = find(des,par,r);
            if(a1==a2) {
                return;
            }
            if(r[a2]>r[a1]) {
                int t = a1;
                a1 = a2;
                a2 = t;
            }
            par[a2] = a1;
            if(r[a1]==r[a2]) {
                r[a1]++;
            }
        }
        public static int find(int j,int [] par,int [] r) {
            int l = j;
            while(par[l]!=l) {
                par[l] = par[par[l]];
                l = par[l];
            }
            return l;
        }
}
