import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
        int [] dis = new int[n+1];
        int val = Integer.MAX_VALUE;
        for(int j=0;j<=n;j++) {
            l1.add(new ArrayList<Integer>());
            l2.add(new ArrayList<Integer>());
            dis[j] = val;
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int wgh = Integer.parseInt(st.nextToken());
            l1.get(src).add(des);
            l2.get(src).add(wgh);
            l1.get(des).add(src);
            l2.get(des).add(wgh);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x,y)-> {
            if(dis[x]<dis[y]) {
                return -1;
            }
            if(dis[x]>dis[y]) {
                return 1;
            }
            return 0;
        });
        dis[1] = 0;
        queue.add(1);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            ArrayList<Integer> ngh = l1.get(x);
            ArrayList<Integer> wgh1 = l2.get(x);
            int c = 0;
            while(c<ngh.size()) {
                int l = ngh.get(c);
                int w = wgh1.get(c);
                int max = Math.max(dis[x],w);
                if(max<dis[l]) {
                    dis[l] = max;
                    queue.add(l);
                }
                c++;
            }
        }
        for(int k=1;k<=n;k++) {
            if(dis[k]!=val) {
                pw.print(dis[k] + " ");
            }   
            else {
                pw.print("-1" + " ");
            }
        }
        pw.close();
    }
}