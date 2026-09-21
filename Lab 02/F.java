import java.io.*;
import java.util.*;
 
public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int [] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }  
        for(int j=0;j<q;j++) {
            int [] qry = new int[2];
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<qry.length;k++) {
                qry[k] = Integer.parseInt(st.nextToken());
            }
            int n1 = qry[0];
            int n2 = qry[1];
            int p1 = 0;
            int q1 = l-1;
            int x1 = l;
            while(p1<=q1) {
                int mid1 = (p1+q1)/2;
                if(arr[mid1]>=n1) {
                    x1 = mid1;
                    q1 = mid1-1;
                }
                else {
                    p1 = mid1+1;
                }
            }
            int p2 = 0;
            int q2 = l-1;
            int x2 = -1;
            while(p2<=q2) {
                int mid2 = (p2+q2)/2;
                if(arr[mid2]<=n2) {
                    x2 = mid2;
                    p2 = mid2+1;
                }
                else {
                    q2 = mid2-1;
                }
            }
            if((x2-x1+1)>0) {
                pw.println(x2-x1+1);
            }
            else {
                pw.println(0);
            }
        }
        pw.close();
    }
}