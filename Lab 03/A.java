import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int [] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] res = mergeSort(arr);
        pw.println(count);
        for(int j=0;j<l;j++) {
            pw.print(res[j] + " ");
        }
        pw.close();
    }
    static long count = 0;
    public static int [] mergeSort(int[] arr) {
        if(arr.length<=1) {
            return arr;
        }
        int mid = arr.length/2;
        int [] arr1 = new int[mid];
        int [] arr2 = new int[arr.length-mid];
        for(int i=0;i<arr.length;i++) {
            if(i<mid) {
                arr1[i] = arr[i];
            }
            else {
                arr2[i-mid] = arr[i]; 
            }
        }
        int [] l = mergeSort(arr1);
        int [] r = mergeSort(arr2);
        return merge(l,r);
    }
    public static int [] merge(int[] l,int[] r) {
        int [] x = new int[l.length+r.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<l.length && j<r.length) {
            if(l[i]<=r[j]) {
                x[k] = l[i];
                i++;
            }
            else {
                x[k] = r[j];
                j++;
                count = count+l.length-i;
            }
            k++;
        }
        while(i<l.length) {
            x[k] = l[i];
            k++;
            i++;
        }
        while(j<r.length) {
            x[k] = r[j];
            k++;
            j++;
        }
        return x;
    }
}


        