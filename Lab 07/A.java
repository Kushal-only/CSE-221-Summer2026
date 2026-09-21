import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<Integer> src = new ArrayList<Integer>();
        ArrayList<Integer> des = new ArrayList<Integer>();
        ArrayList<Integer> wgh = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
        int val = Integer.MAX_VALUE;
        int [] dis = new int[n+1];
        int [] par = new int[n+1];
        ArrayList<Integer> route = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int k=0;k<=n;k++) {
            l1.add(new ArrayList<Integer>());
            l2.add(new ArrayList<Integer>());
            par[k] = -1;
            dis[k] = val;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
           int a = Integer.parseInt(st.nextToken());
           src.add(a);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int b = Integer.parseInt(st.nextToken());
            des.add(b);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int c = Integer.parseInt(st.nextToken());
            wgh.add(c);
        }
        for(int j=0;j<m;j++) {
            l1.get(src.get(j)).add(des.get(j));
            l2.get(src.get(j)).add(wgh.get(j));
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
        dis[s] = 0;
        queue.add(s);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            ArrayList<Integer> ngh = l1.get(x);
            ArrayList<Integer> wgh1 = l2.get(x);
            int c = 0;
            while(c<ngh.size()) {
                int l = ngh.get(c);
                int w = wgh1.get(c);
                if(dis[x]+w<dis[l]) {
                    dis[l] = dis[x]+w;
                    par[l] = x;
                    queue.add(l);
                }
                c++;
            }
        }
        if(dis[d]>=val) {
            pw.println(-1);
        }
        else {
            pw.println(dis[d]);
            int rec = d;
            while(rec!=-1) {
                route.add(rec);
                rec = par[rec];
            }
            for(int h=route.size()-1;h>=0;h--) {
                res.add(route.get(h));
            }
            for(int i=0;i<res.size();i++) {
                pw.print(res.get(i) + " ");
            }
        }
        pw.close();
    }
}
