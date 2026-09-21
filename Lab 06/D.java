import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for(int i=0;i<=n;i++) {
            l1.add(-1);
        }
        for(int j=1;j<n;j++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            l3.add(des);
            l2.add(l1.get(src));
            l1.set(src,cnt);
            cnt++;
            l3.add(src);
            l2.add(l1.get(des));
            l1.set(des,cnt);
            cnt++;
        }
        int lA = bfs(1,n);
        int lB = bfs(lA,n);
        int r = dis.get(lB);
        pw.println(r);
        pw.println(lA + " " + lB);
        pw.close();
    }
    static ArrayList<Integer> l1 = new ArrayList<>();
    static ArrayList<Integer> l2 = new ArrayList<>();
    static ArrayList<Integer> l3 = new ArrayList<>();
    static ArrayList<Integer> queue = new ArrayList<>();
    static ArrayList<Integer> dis = new ArrayList<>();
    public static int bfs(int cur,int n) {
        int cnt2 = cur;
        dis.clear();
        int k = 0;
        while(k<=n) {
            dis.add(-1);
            k++;
        }
        queue.clear();
        dis.set(cur,0);
        queue.add(cur);
        int l = 0;
        while(l<queue.size()) {
            int n1 = queue.get(l);
            if(dis.get(cnt2)<dis.get(n1)) {
                cnt2 = n1;
            }
            int w = l1.get(n1);
            while(w!=-1) {
                int n2 = l3.get(w);
                if(dis.get(n2)==-1) {
                    int m = dis.get(n1)+1;
                    dis.set(n2,m);
                    queue.add(n2);
                }
                w = l2.get(w);
            }
            l++;
        }
        return cnt2;
    }
}
