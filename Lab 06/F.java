import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> dis = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> forb = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<10000;i++) {
            forb.add(0);
            dis.add(-1);
        }
        for(int j=0;j<n;j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            forb.set(x,1);
        }
        dis.set(s,0);
        queue.add(s);
        l.add(1000);
        l.add(100);
        l.add(10);
        l.add(1);
        int z = 0;
        while(z<queue.size()) {
            int n1 = queue.get(z);
            if(n1==c) {
                break;
            }
            int p = 0;
            while(p<4) {
                int e = l.get(p);
                int dig = (n1/e)%10;
                int dig1 = (dig+1)%10;
                int a = n1-dig*e;
                int b = dig1*e;
                int v = a+b;
                if(forb.get(v)==0) {
                    if(dis.get(v)==-1) {
                        dis.set(v,dis.get(n1)+1);
                        queue.add(v);
                    }
                }
                int dig2 = (dig+9)%10;
                int g = n1-dig*e;
                int h = dig2*e;
                int u = g+h;
                if(forb.get(u)==0) {
                    if(dis.get(u)==-1) {
                        dis.set(u,dis.get(n1)+1);
                        queue.add(u);
                    }
                }
                p++;
            }
            z++;
        }
        int d = dis.get(c);
        pw.println(d);
        pw.close();
    }
}
