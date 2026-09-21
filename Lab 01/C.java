import java.io.*;
import java.util.StringTokenizer;

public class fastSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PrintWriter pw =  new PrintWriter(System.out);
        for(int i=0;i<n;i++) {
            long m = Integer.parseInt(br.readLine());
            long sum = m*(m+1)/2;
            pw.println(sum);
        }
        pw.close();
    }
}
    




