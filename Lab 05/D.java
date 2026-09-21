import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] src = new int[m];
        int [] des = new int[m];
        int [] path = new int[n];
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int [] arr1 = new int[n+1];
        int [] arr2 = new int[m];
        int [] arr3 = new int[m];
        int [] arr4 = new int[n+1];
        int [] queue = new int[n];
        int [] dis1 = new int[n+1];
        int [] dis2 = new int[n+1];
        int [] p1 = new int[n+1];
        int [] p2 = new int[n+1];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            src[i] = Integer.parseInt(st.nextToken());
            des[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        while(l<=n) {
            dis1[l] = -1;
            dis2[l] = -1;
            arr1[l] = -1;
            arr4[l] = -1;
            p1[l] = -1;
            p2[l] = -1;
            l++;
        }
        for(int x=0;x<m;x++) {
            arr3[x] = des[x];
            arr2[x] = arr1[src[x]];
            arr1[src[x]] = x;
        }
        dis1[s] = 0;
        queue[cnt1] = s;
        cnt1++;
        for(int y=0;y<cnt1;y++) {
            int n1 = queue[y];
            int w = arr1[n1];
            while(w!=-1) {
                int n2 = arr3[w];
                if(dis1[n2]==-1) {
                    dis1[n2] = dis1[n1]+1;
                    p1[n2] = n1;
                    queue[cnt1] = n2;
                    cnt1++;
                }
                w = arr2[w];
            }
        }
        for(int v=0;v<m;v++) {
            arr3[v] = src[v];
            arr2[v] = arr4[des[v]];
            arr4[des[v]] = v;
        }
        dis2[d] = 0;
        queue[cnt2] = d;
        cnt2++;
        for(int b=0;b<cnt2;b++) {
            int n1 = queue[b];
            int w = arr4[n1];
            while(w!=-1) {
                int n2 = arr3[w];
                if(dis2[n2]==-1) {
                    dis2[n2] = dis2[n1]+1;
                    p2[n2] = n1;
                    queue[cnt2] = n2;
                    cnt2++;
                }
                w = arr2[w];
            }
        }
        if(dis1[k]!=-1 && dis2[k]!=-1) {
            pw.println(dis1[k]+dis2[k]);
            int r = k;
            while(r!=-1) {
                path[cnt3] = r;
                r = p1[r];
                cnt3++;
            }
        for(int z=cnt3-1;z>=0;z--) {
            pw.print(path[z] + " ");
        }
        int r1 = p2[k];
        while(r1!=-1) {
            pw.print(r1 + " ");
            if(r1==d) {
                break;
            }
            r1 = p2[r1];
        }
    }
    else {
        pw.println(-1);
    }
        pw.close();
    }
}
