import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args)throws IOException {
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<String> grps = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        int cnt = 0;
        int cnt1 = 0;
        for(int i=0;i<=n;i++) {
            l1.add(-1);
        }
        for(int k=0;k<=n;k++) {
            grps.add(null);
        }
        for(int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l3.add(b);
            l2.add(l1.get(a));
            l1.set(a,cnt++);
            l3.add(a);
            l2.add(l1.get(b));
            l1.set(b,cnt++);
        }
        for(int x=1;x<=n;x++) {
            if(grps.get(x)==null) {
                queue.clear();
                grps.set(x,"A");
                queue.add(x);
                int cntA = 1;
                int cntB = 0;
                int l = 0;
                while(l<queue.size()) {
                    int n1 = queue.get(l);
                    int w = l1.get(n1);
                    while(w!=-1) {
                        int n2 = l3.get(w);
                        if(grps.get(n2)==null) {
                            if(grps.get(n1).equals("A")) {
                                grps.set(n2,"B");
                                cntB++;
                            }
                            else if(grps.get(n1).equals("B")) {
                                grps.set(n2,"A");
                                cntA++;
                            }
                            queue.add(n2);
                        }
                        w = l2.get(w);
                    }
                    l++;
                }
                cnt1 = cnt1 + Math.max(cntA,cntB);
            }
        }
        pw.println(cnt1);
        pw.close();
    }
}
