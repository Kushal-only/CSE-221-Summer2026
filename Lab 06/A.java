import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            ArrayList<Integer> l3 = new ArrayList<>();
            ArrayList<String> color = new ArrayList<>();
            ArrayList<Integer> l4 = new ArrayList<>();
            ArrayList<Integer> s1 = new ArrayList<>();
            ArrayList<Integer> s2 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<=n;j++) {
                l1.add(-1);
            }
            for(int l=0;l<=n;l++) {
                color.add("wh");
            }
            for(int j=0;j<m;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                l3.add(b);
                l2.add(l1.get(a));
                int x = l2.size();
                l1.set(a,x-1);
            }
            boolean flag = false;
            int y=1;
            while(y<=n && !flag) {
                if(color.get(y).equals("wh")) {
                    s1.add(y);
                    s2.add(l1.get(y));
                    color.set(y,"gr");
                    while(!s1.isEmpty() && !flag) {
                        int t1 = s1.size()-1;
                        int t2 = s1.get(t1);
                        int w = s2.get(t1);
                        if(w==-1) {
                            color.set(t2,"bl");
                            l4.add(t2);
                            s1.remove(t1);
                            s2.remove(t1);
                        }
                        else {
                            s2.set(t1,l2.get(w));
                            int n1 = l3.get(w);
                            if(color.get(n1).equals("wh")) {
                                color.set(n1,"gr");
                                s1.add(n1);
                                s2.add(l1.get(n1));
                            }
                            else if(color.get(n1).equals("gr")) {
                                flag = true;
                            }
                        }
                    }
                } 
                y++;
            }
            if(flag==false){
                for(int v=l4.size()-1;v>=0;v--) {
                    pw.print(l4.get(v) + " ");
                }
            }
            else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}
