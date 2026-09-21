import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<Integer> dis = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<=n;i++) {
            l1.add(-1);
        }
        for(int j=0;j<=n;j++) {
            dis.add(-1);
        }
        int k = 0;
        while(k<m) {
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
            k++; 
        }
        st = new StringTokenizer(br.readLine());
        for(int l=0;l<s;l++) {
            int nSrc = Integer.parseInt(st.nextToken());
            if(dis.get(nSrc)==-1) {
                dis.set(nSrc,0);
                queue.add(nSrc);
            }
        }
        int a = 0;
        while(a<queue.size()) {
            int n1 = queue.get(a);
            int w = l1.get(n1);
            while(w!=-1) {
                int n2 = l3.get(w);
                if(dis.get(n2)==-1) {
                    int b = dis.get(n1)+1;
                    dis.set(n2,b);
                    queue.add(n2);
                }
                w = l2.get(w);
            }
            a++;
        }
        st = new StringTokenizer(br.readLine());
        int p = 0;
        while(p<q) {
            int nDes = Integer.parseInt(st.nextToken());
            int c = dis.get(nDes);
            pw.print(c +" ");
            p++;
        }
        pw.close();
    }
}
