import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [] arr = new int[n+1];
        boolean flag = true;
        ArrayList<Integer> moves = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(flag) {
            flag = false;
            for(int i=1;i<=n-2;i++) {
                if(arr[i]>arr[i+2]) {
                    int temp = arr[i];
                    arr[i] = arr[i+2];
                    arr[i+2] = temp;
                    moves.add(i);
                    flag = true;
                }
            }
        }
        boolean flag2 = true;
        for(int i=1;i<n;i++) {
            if(arr[i]>arr[i+1]) {
                flag2 = false;
                break;
            }
        }
        if(flag2==false) {
            pw.println("NO");
        }
        else {
            pw.println("YES");
            pw.println(moves.size());
            for(int i=0;i<moves.size();i++) {
                pw.println(moves.get(i) + " " + (moves.get(i)+2));
            }
        }
        pw.flush();
    }
}
