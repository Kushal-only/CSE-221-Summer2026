import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int k=0;k<t;k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Long>> l2 = new ArrayList<ArrayList<Long>>();
            long [] dis = new long[n+1];
            int [] visited = new int[n+1];
            long val = Long.MAX_VALUE;
            for(int i=0;i<=n;i++) {
                l1.add(new ArrayList<Integer>());
                l2.add(new ArrayList<Long>());
                dis[i] = val;
            } 
            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                long wgh = Long.parseLong(st.nextToken());
                l1.get(src).add(des);
                l2.get(src).add(wgh);
            }
            Queue<Integer> queue = new ArrayDeque<Integer>();
            dis[1] = 0;
            queue.add(1);
            visited[1] = 1;
            while(!queue.isEmpty()) {
                int x = queue.poll();
                visited[x] = 0;
                ArrayList<Integer> ngh = l1.get(x);
                ArrayList<Long> wgh1 = l2.get(x);
                int c = 0;
                while(c<ngh.size()) {
                    int p = ngh.get(c);
                    long q = wgh1.get(c);
                    if(dis[x]!=val) {
                        if(dis[p]>dis[x]+q) {
                            dis[p] = dis[x]+q;
                            if(visited[p]==0) {
                                visited[p] = 1;
                                queue.add(p);
                            }
                        }
                    }
                    c++;
                }
            }
            pw.println(dis[n]);
        }
        pw.close();
    }
}
