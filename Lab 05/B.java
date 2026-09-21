import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int [] src = new int[y];
        int [] des = new int[y];
        int [] arr1 = new int[x+1];
        int [] arr2 = new int[2*y];
        int [] arr3 = new int[2*y];
        visited = new int[x+1];
        start = new int [x+1];
        end = new int[x+1];
        int t = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<y;i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<y;j++) {
            des[j] = Integer.parseInt(st.nextToken());
        }
        for(int q=0;q<=x;q++) {
            arr1[q] = -1;
        }
        int k =0;
        while(k<y) {
            arr3[cnt] = des[k];
            arr2[cnt] = arr1[src[k]];
            arr1[src[k]] = cnt;
            cnt++;
            arr3[cnt] = src[k];
            arr2[cnt] = arr1[des[k]];
            arr1[des[k]] = cnt;
            cnt++;
            k++;
        }
        dfs(1,t,arr1,arr2,arr3,pw);
        pw.close();
    }
    static int [] visited;
    static int [] start;
    static int [] end;
    public static void dfs(int sNode,int t,int [] arr1,int [] arr2,int [] arr3,PrintWriter pw) {
        visited[sNode] = 1;
        t = t+1;
        start[sNode] = t;
        pw.print(sNode + " ");
        int w = arr1[sNode];
        while(w!=-1) {
            int p = arr3[w];
            if(visited[p]==0) {
                dfs(p,t,arr1,arr2,arr3,pw);
            }
            w = arr2[w];
        }
        t++;
        end[sNode] = t;
    }
}
