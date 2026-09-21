import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int [] dis1 = new int[n+1];
        int [] dis2 = new int[n+1];
        int val = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
        for(int k=0;k<=n;k++) {
            l1.add(new ArrayList<Integer>());
            l2.add(new ArrayList<Integer>());
            dis1[k] = val;
            dis2[k] = val;
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
            if(dis1[x]<dis1[y]) {
                return -1;
            }
            if(dis1[x]>dis1[y]) {
                return 1;
            }
            return 0;
        });
        dis1[s] = 0;
        queue.add(s);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            ArrayList<Integer> ngh = l1.get(x);
            ArrayList<Integer> wgh1 = l2.get(x);
            int c = 0;
            while(c<ngh.size()) {
                int p = ngh.get(c);
                int q = wgh1.get(c);
                if(dis1[x]!=val) {
                    int nDis = dis1[x]+q;
                    if(dis1[p]>nDis) {
                        dis2[p] = dis1[p];
                        dis1[p] = nDis;
                        queue.add(p);
                    }
                    else if(nDis>dis1[p]) {
                        if(nDis<dis2[p]) {
                            dis2[p] = nDis;
                            queue.add(p);
                        }
                    }
                }
                if(dis2[x]!=val) {
                    int nDis2 = dis2[x]+q;
                    if(nDis2>dis1[p]) {
                        if(nDis2<dis2[p]) {
                            dis2[p] = nDis2;
                            queue.add(p);
                        }
                    }
                }
            c++;
            }
        }
        if(dis2[d]!=val) {
            pw.println(dis2[d]);
        }
        else {
            pw.println(-1);
        }
        pw.close();
    }
}
