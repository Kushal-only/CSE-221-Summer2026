import java.io.*;
import java.util.StringTokenizer;

public class calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st; 
        double sum = 0;
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double n1 = Double.parseDouble(st.nextToken());
            String op = st.nextToken();
            double n2 = Double.parseDouble(st.nextToken());
            if(op.equals("+")) {
                sum = n1+n2;
            }
            if(op.equals("-")) {
                sum = n1-n2;
            }
            if(op.equals("*")) {
                sum = n1*n2;
            }
            if(op.equals("/")) {
                sum = n1/n2;
            }
            if(op.equals("%")) {
                sum = n1%n2;
            }
            if(op.equals("&")) {
                sum = (double)((int)n1&(int)n2);
            }
            if(op.equals("|")) {
                sum = (double)((int)n1|(int)n2);
            }
            if(op.equals("^")) {
                sum =(double)((int)n1^(int)n2);
            }
            if(op.equals("<<")) {
                sum = (double)((long)n1<<(long)n2);
            }
            if(op.equals(">>")) {
                sum = (double)((long)n1>>(long)n2);
            }
            pw.println(sum);
        }
        pw.close();
    }
}

