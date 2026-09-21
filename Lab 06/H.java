import java.io.*;
import java.util.*;

public class H {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String a = st.nextToken();
        String b = st.nextToken();
        int [][] arr = new int[26][26];
        int [] visited = new int[26];
        int [] queue = new int[26];
        int cnt = 0;
        int s1 = a.charAt(a.length()-1)-'A';
        int l1 = b.charAt(0)-'A';
        for(int i=0;i<n;i++) {
            String p = br.readLine();
            int x = p.length();
            int f = p.charAt(0)-'A';
            int l = p.charAt(x-1)-'A';
            arr[f][l] = 1;
        }
        visited[s1] = 1;
        queue[cnt] = s1;
        cnt++;
        int j = 0;
        while(j<cnt) {
            int n1 = queue[j];
            int w = 0;
            while(w<26) {
                if(arr[n1][w]==1) {
                    if(visited[w]==0) {
                        visited[w] = 1;
                        queue[cnt] = w;
                        cnt++;
                    }
                }
                w++;
            }
            j++;
        } 
        if(visited[l1]==1) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }
        pw.close();
    }
}
