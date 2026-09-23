import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [] temp = new int[n];
        int [] arr = new int[n];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<n;i++) {
            for(int left=0;left<n;left=left+2*i) {
                int mid = left+i-1;
                int right = left+2*i-1;
                if(mid>=n-1) {
                    continue;
                }
                if(right>=n) {
                    right = n-1;
                }
                int ptr = left;
                for(int j=mid+1;j<=right;j++) {
                    int tar = arr[j]*arr[j];
                    while(ptr<=mid&&arr[ptr]<=tar) {
                        ptr++;
                    }
                    cnt += (mid-ptr+1);
                }
                int k = left;
                int j = mid+1;
                int x = left;
                while(k<=mid&&j<=right) {
                    if(arr[k]<=arr[j]) {
                        temp[x] = arr[k];
                        k++;
                    }
                    else {
                        temp[x] = arr[j];
                        j++;
                    }
                    x++;
                }
                while(k<=mid) {
                    temp[x] = arr[k];
                    x++;
                    k++;
                }
                while(j<=right) {
                    temp[x] = arr[j];
                    j++;
                    x++;
                }
                for(int p=left;p<=right;p++) {
                    arr[p] = temp[p];
                }
            }
        }
        pw.println(cnt);
        pw.close();
    }
}
