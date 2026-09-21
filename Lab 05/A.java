import java.io.*;
import java.util.*;

public class A {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[x+1];
        int [] arr2 = new int[y*2];
        int [] arr3 = new int[y*2];
        int [] visited = new int[x+1];
        int [] parent = new int[x+1];
        int [] dis = new int[x+1];
        int [] queue = new int[x];
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<=x;i++) {
            arr1[i] = -1;
        }
        for(int j=0;j<y;j++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            arr3[cnt1] = des;
            arr2[cnt1] = arr1[src];
            arr1[src] = cnt1++;
            arr3[cnt1] = src;
            arr2[cnt1] = arr1[des];
            arr1[des] = cnt1++;
        }
        int sNode = 1;
        visited[sNode] = 1;
        parent[sNode] = -1;
        dis[sNode] = 0;
        queue[cnt2] = sNode;
        cnt2++;
        for(int k=0;k<cnt2;k++) {
            int p = queue[k];
            pw.print(p + " ");
            int w = arr1[p];
            while(w!=-1) {
              int q = arr3[w];
              if(visited[q]==0) {
                 visited[q] = 1;
                 dis[q] = dis[p]+1;
                 parent[q] = p;
                 queue[cnt2] = q;
                 cnt2++;
              }
              w = arr2[w];
            }
        }
        pw.println();
        pw.flush();
    }
}
