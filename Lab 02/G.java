import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n+1];
        int low =0;
        int high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>low) {
                low = arr[i];
            }
            high += arr[i];
        }
        int ans = high;
        while(low<=high) {
            int mid = low+(high-low)/2;
            int pieces = 1;
            int curSum = 0;
            for(int i=0;i<n;i++) {
                if(curSum+arr[i]>mid) {
                    pieces++;
                    curSum = arr[i];
                }
                else {
                    curSum += arr[i];
                }
            }
            if(pieces<=k) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
