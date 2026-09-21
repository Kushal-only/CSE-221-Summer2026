import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        for(int j=0;j<=n;j++) {
            l1.add(new ArrayList<Integer>());
            l2.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int wgh = Integer.parseInt(st.nextToken());
            l1.get(src).add(des);
            l2.get(src).add(wgh);
        }
        int [] aliceDis = dijkstra(n,s);
        int [] bobDis  = dijkstra(n,t);
        int val1 = val;
        int n1 = -1;
        int k = 1;
        while(k<=n) {
            if(aliceDis[k]<val) {
                if(bobDis[k]<val) {
                    int time = Math.max(aliceDis[k],bobDis[k]);
                    if(time<val1) {
                        val1 = time;
                        n1 = k;
                    }
                }
            }
            k++;
        }
        if(n1!=-1) { 
            pw.println(val1 + " " +n1);
        }
        else if(n1==-1) {
            pw.println(-1);
        }
        pw.close();
    }
    static ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
    static int val = Integer.MAX_VALUE/2;
    public static int[] dijkstra(int n,int s) {
        int [] dis = new int[n+1];
        for(int i=0;i<=n;i++) {
            dis[i] = val;
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
                        queue.add(l);
                    }
                    c++;
            }
        }
        return dis;
    }
}
