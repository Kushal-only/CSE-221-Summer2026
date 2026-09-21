import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long r = 1;
        while(y>0) {
            if(y%2!=0) {
                r = (r*x)%107;
            }
            x = (x*x)%107;
            y = y/2;
        }
        pw.print(r);
        pw.close();
    }
}

