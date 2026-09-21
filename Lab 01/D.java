import java.io.*;
import java.util.StringTokenizer;

public class isSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            boolean flag = true;
            int l = Integer.parseInt(br.readLine());
            int [] arr = new int[l];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<l;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int k=0;k<l-1;k++) {
                if(l>1) {
                 if(!(arr[k]<=arr[k+1])) {
                    flag = false;
                    break;
                }
            }
        }
            if(flag==true) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }
        }
        pw.close();
    }
}
