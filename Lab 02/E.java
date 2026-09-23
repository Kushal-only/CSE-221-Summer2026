import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        int [] cnt = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int distinct = 0;
        int maxlen = 0;
        int left = 0;
        for(int i=0;i<n;i++) {
            int val = arr[i];
            if(cnt[val]==0) {
                distinct++;
            }
            cnt[val]++;
            while(distinct>k) {
                int leftval = arr[left];
                cnt[leftval]--;
                if(cnt[leftval]==0) {
                    distinct--;
                }
                left++;
            }
            int curlen = i-left+1;
            if(curlen>maxlen) {
                maxlen = curlen;
            }
        }
        pw.println(maxlen);
        pw.close();
    }
}