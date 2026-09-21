import java.io.*;
import java.util.*;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l1 = Integer.parseInt(st.nextToken());
        long val = Long.parseLong(st.nextToken());
        int [] arr = new int[l1];
        int l2 = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l1;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>l2) {
                l2 = arr[i];
            }
        }
        int p = 1;
        int q = l2;
        boolean flag = false;
        long prev = 0;
        while(p<=q) {
           long x = 0;
           int mid = (p+q)/2;
            for(int k=0;k<l1;k++) {
                x += arr[k]/mid;
            }
            if(x>=val) {
                prev = mid;
                flag = true;
                p = mid+1;
            }
            else{
                q = mid-1;
            }
        }
        if(flag==true) {
            pw.println(prev);
        }
        else {
            pw.println(-1);
        }
        pw.close();
    }
}