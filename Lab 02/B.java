import java.io.*;
import java.util.*;

public class twoSumRevisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l1 = Integer.parseInt(st.nextToken());
        int l2 = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[l1];
        int [] arr2 = new int[l2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l1;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<l2;j++) {
            arr2[j] =  Integer.parseInt(st.nextToken());
        }
        int p = 0;
        int q = l2-1;
        int idx1 = p+1;
        int idx2 = q+1;
        int d1 = Math.abs(arr1[p]+arr2[q]-t);
        while(p<l1 && q>=0)  {
            int d2 = Math.abs(arr1[p]+arr2[q]-t);
            if(d1>d2) {
                d1 = d2;
                idx1 = p+1;
                idx2 = q+1;
            }
            else if(arr1[p]+arr2[q]==t) {
                break;
            }
            else if(arr1[p]+arr2[q]>t) {
                q--;
            }
            else if(arr1[p]+arr2[q]<t) {
                p++;
            }
        }
        pw.println(idx1 + " " + idx2);
        pw.close();
    }
}