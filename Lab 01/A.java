import java.io.*;
import java.util.StringTokenizer;

public class oddOreven {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0;i<num1;i++) {
            int num2 = Integer.parseInt(br.readLine());
            if(num2%2==0) {
                pw.println(num2 + " is an Even number.");
            }
            else {
                pw.println(num2 + " is an Odd number.");
            }
        }
        pw.close();
    }
}
