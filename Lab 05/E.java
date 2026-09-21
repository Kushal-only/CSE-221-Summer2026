import java.io.*;
import java.util.*;

public class E {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[n+1];
        int e = n-1;
        int [] arr2 = new int[2*e];
        int [] arr3 = new int[2*e];
        int cnt = 0;
        int cnt1 = 0;
        int [] sub = new int[n+1];
        int [] visited = new int[n+1];
        int [] par = new int[n+1];
        int [] arr4 = new int[n];
        for(int i=0;i<=n;i++) {
            arr1[i] = -1;
        }
        for(int c=0;c<=n;c++) {
            sub[c] = 1;
        }
        for(int j=0;j<e;j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr3[cnt] = y;
            arr2[cnt] = arr1[x];
            arr1[x] = cnt;
            cnt++;
            arr3[cnt] = x;
            arr2[cnt] = arr1[y];
            arr1[y] = cnt;
            cnt++;
        }
        par[r] = -1;
        visited[r] = 1;
        arr4[cnt1] = r;
        cnt1++;
        int p = 0;
        while(p<cnt1) {
            int n1 = arr4[p];
            int w = arr1[n1];
            while(w!=-1) {
                int n2 = arr3[w];
                if(visited[n2]!=1) {
                    visited[n2] = 1;
                    par[n2] = n1;
                    arr4[cnt1] = n2;
                    cnt1++;
                }
                w = arr2[w];
            }
            p++;
        }
        for(int d=cnt1-1;d>=0;d--) {
            int n1 = arr4[d];
            if(par[n1]!=-1) {
                int n2 = par[n1];
                sub[n2] = sub[n2]+sub[n1];
            }
        }
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for(int l=0;l<q;l++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            pw.println(sub[x]);
        }
        pw.close();
    }
}
