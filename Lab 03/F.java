import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int [] arr = new int[l];
        int [] arr2 = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bst(arr,arr2,0,l-1);
        for(int j=0;j<l;j++) {
            pw.print(arr2[j] + " ");
        }
        pw.close();
    }
    static int i = 0;
    public static void bst(int[] arr,int[] arr2,int l,int r) {
        if(l>r) {
            return;
        }
        int mid = (l+r)/2;
        arr2[i] = arr[mid];
        i++;
        bst(arr,arr2,l,mid-1);
        bst(arr,arr2,mid+1,r);
    }
}
