import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        int [] nWgh = new int[n+1];
        int [] dis  = new int[n+1];
        int val = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int j=1;j<=n;j++) {
            nWgh[j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=n;i++) {
            l1.add(new ArrayList<Integer>());
            dis[i] = val;
        }
        for(int k=0;k<m;k++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            l1.get(src).add(des);
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
        dis[s] = nWgh[s];
        queue.add(s);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            ArrayList<Integer> ngh = l1.get(x);
            int c = 0;
            while(c<ngh.size()) {
                int l = ngh.get(c);
                if(dis[x]+nWgh[l]<dis[l]) {
                    dis[l] = dis[x]+nWgh[l];
                    queue.add(l);
                }
                c++;
            }
        }
        if(dis[d]!=val) {
            pw.println(dis[d]);
        }
        else {
            pw.println(-1);
        }
        pw.close();
    }
}

