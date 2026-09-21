import java.io.*;
import java.util.*;

public class twoSumTrouble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int [] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = false;
        int idx1 = 0;
        int idx2 = 0;
        int p = 0;
        int q = l-1;
        while(p<q) {
            if(arr[p]+arr[q]==t) {
                idx1 = p+1;
                idx2 = q+1;
                flag = true;
                break;
            }
            else if(arr[p]+arr[q]>t) {
                q--;
            }
            else if(arr[p]+arr[q]<t) {
                p++;
            }
        }
        if(flag==true) {
            pw.println(idx1 + " " + idx2);
        }
        else {
            pw.println("-1");
        }
        pw.close();
    }
}