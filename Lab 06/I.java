import java.io.*;
import java.util.*;

public class I {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [][] arr = new int[26][26];
        ArrayList<String> ins = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        int cnt = 0;
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<Character> res = new ArrayList<>();
        int cnt1 = 0;
        for(int j=0;j<26;j++) {
            l1.add(0);
            l2.add(0);
            l3.add(0);
        }
        for(int i=0;i<n;i++) {
            String w = br.readLine();
            ins.add(w);
        }
        for(int k=0;k<n;k++) {
            String w = ins.get(k);
            int s=0;
            while(s<w.length()) {
                int x = w.charAt(s)-'a';
                l2.set(x,1);
                s++;
            }
        }
        int l = 0;
        while(l<n-1) {
            String a = ins.get(l);
            String b = ins.get(l+1);
            int len = Math.min(a.length(),b.length());
            int y = -1;
            int z = 0;
            while(z<len) {
                if(a.charAt(z)!=b.charAt(z)) {
                    y = z;
                    break;
                }
                z++;
            }
            if(y!=-1) {
                int p = a.charAt(y)-'a';
                int q = b.charAt(y)-'a';
                if(arr[p][q]==0) {
                    arr[p][q] = 1;
                    l1.set(q,l1.get(q)+1);
                }
            }
            else {
                if(a.length()>b.length()) {
                    cnt = 1;
                }
            }
            l++;
        } 
        if(cnt==1) {
            pw.println(-1);
            pw.close();
            return;
        }
        for(int x=0;x<26;x++) {
            if(l2.get(x)==1) {
                cnt1++;
            }
        }
        for(int m=0;m<cnt1;m++) {
            int c = -1;
            int z = 0;
            while(z<26) {
                if(l2.get(z)==1) {
                    if(l3.get(z)==0) {
                        if(l1.get(z)==0) {
                            c = z;
                            break;
                        }
                    }
                }
                z++;
            }
            if(c==-1) {
                break;
            }
            l3.set(c,1);
            int u = c+'a';
            char ch = (char)u;
            res.add(ch);
            int v = 0;
            while(v<26) {
                if(arr[c][v]==1) {
                    l1.set(v,l1.get(v)-1);
                }
                v++;
            }
        }
        if(res.size()!=cnt1) {
            pw.println(-1);
        }
        else {
            for(int j=0;j<res.size();j++) {
                pw.print(res.get(j));
            }
        }
        pw.close();
    }
}
