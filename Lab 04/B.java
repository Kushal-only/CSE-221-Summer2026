import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader((System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] src = new int[m];
        int [] des = new int[m];
        int [] wgh = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<m;j++) {
            des[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int k=0;k<m;k++) {
            wgh[k] = Integer.parseInt(st.nextToken());
        }
        for(int x=1;x<=n;x++) {
            pw.print(x + ":");
            for(int y=0;y<m;y++) {
                if(src[y]==x) {
                    pw.print("(" + des[y] + "," + wgh[y] + ")");
                }
            }
            pw.println();
        }
        pw.close();
    }
}
