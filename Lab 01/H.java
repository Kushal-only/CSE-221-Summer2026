import java.io.*;
import java.util.*;

public class H {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String [] full = new String[n];
        String [] train = new String[n];
        int [] time = new int[n];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            full[i] = s;
            st = new StringTokenizer(s);
            train[i] = st.nextToken(); // train name
            st.nextToken(); // will
            st.nextToken(); // departure
            st.nextToken(); // for
            st.nextToken(); // destination
            st.nextToken(); //at
            String t = st.nextToken(); // time in hour:minute
            int h = (t.charAt(0)-'0')*10+(t.charAt(1)-'0');
            int m = (t.charAt(3)-'0')*10+(t.charAt(4)-'0');
            time[i] = h*60+m;
        }
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-1-i;j++) {
                String s1 = train[j];
                String s2 = train[j+1];
                int len1 = s1.length();
                int len2 = s2.length();
                int minlen;
                if(len1<len2) {
                    minlen = len1;
                }
                else {
                    minlen = len2;
                }
                int count = 0;
                for(int k=0;k<minlen;k++) {
                    if(s1.charAt(k)!=s2.charAt(k)) {
                        count = s1.charAt(k)-s2.charAt(k);
                        break;
                    }
                }
                if(count==0) {
                    count = len1-len2;
                }
                boolean flag = false;
                if(count>0) {
                    flag = true;
                }
                else if(count==0) {
                    if(time[j]<time[j+1]) {
                        flag = true;
                    }
                }
                if(flag==true) {
                    String temp = train[j];
                    train[j] = train[j+1];
                    train[j+1] = temp;
                    int temp1 = time[j];
                    time[j] = time[j+1];
                    time[j+1] = temp1;
                    String temp2 = full[j];
                    full[j] = full[j+1];
                    full[j+1] = temp2;
                }
            }
        }
        for(int i=0;i<n;i++) {
            pw.println(full[i]);
        }
        pw.close();

    }
}
