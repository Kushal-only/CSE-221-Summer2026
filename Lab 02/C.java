import java.io.*;
import java.util.*;

public class beautifulSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l1 = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[l1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l1;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int l2= Integer.parseInt(st.nextToken());
        int [] arr2= new int[l2];
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<l2;j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }
        int [] r = new int[l1+l2];
        int p = 0;
        int q = 0;
        int x = 0;
        while(p<l1 && q<l2) {
            if(arr1[p]==arr2[q]) {
                r[x] = arr1[p];
                p++;
                x++;
            }
            else if(arr1[p]<arr2[q]) {
                r[x] = arr1[p];
                p++;
                x++;
            }
            else if(arr1[p]>arr2[q]) {
                r[x] = arr2[q];
                q++;
                x++;
            }
        }
        while(p<l1) {
            r[x] = arr1[p];
            p++;
            x++;
        }
        while(q<l2) {
            r[x] = arr2[q];
            x++;
            q++;
        }
        for(int k=0;k<l1+l2;k++) {
            pw.print(r[k] + " ");
        }
        pw.close();
    }
}