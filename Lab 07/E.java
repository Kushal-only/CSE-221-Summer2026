import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
        int [] dis = new int[(n+1)*2];
        int val = Integer.MAX_VALUE;
        int [] src = new int[m];
        int [] des = new int[m];
        int [] wgh = new int[m];
        for(int k=0;k<=n;k++) {
            l1.add(new ArrayList<Integer>());
            l2.add(new ArrayList<Integer>());
        }
        for(int j=0;j<dis.length;j++) {
            dis[j] = val;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int s = Integer.parseInt(st.nextToken());
            src[i] = s;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int d = Integer.parseInt(st.nextToken());
            des[i] = d;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int w = Integer.parseInt(st.nextToken());
            wgh[i] = w;
        }
        for(int i=0;i<m;i++) {
            l1.get(src[i]).add(des[i]);
            l2.get(src[i]).add(wgh[i]);
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
        ArrayList<Integer> ngh2 = l1.get(1);
        ArrayList<Integer> wgh2 = l2.get(1);
        int c = 0;
        while(c<ngh2.size()) {
            int par = wgh2.get(c)%2;
            int b = ngh2.get(c)*2+par;
            if(dis[b]>wgh2.get(c)) {
                dis[b] = wgh2.get(c);
                queue.add(b);
            }
            c++;
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur/2;
            int g = cur%2;
            ArrayList<Integer> ngh1 = l1.get(x);
            ArrayList<Integer> wgh1 = l2.get(x);
            int a = 0;
            while(a<ngh1.size()) {
                int l = ngh1.get(a);
                int wt = wgh1.get(a);
                int cur1 = wt%2;
                if(cur1!=g) {
                    int nxt = l*2+cur1;
                    if(dis[cur]+wt<dis[nxt]) {
                        dis[nxt] = dis[cur]+wt;
                        queue.add(nxt);
                    }
                }
                a++;
            }
        }
        int res = Math.min(dis[n*2+1],dis[n*2]);
        if(res!=val) {
            pw.println(res);
        }
        else {
            pw.println(-1);
        }
        pw.close();
    }
}
