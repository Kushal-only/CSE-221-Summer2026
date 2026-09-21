import java.io.*;
import java.util.*;

public class C {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int [] src = new int[m];
        int [] des = new int[m];
        int [] arr1 = new int[n+1];
        int [] arr2 = new int[2*m];
        int [] arr3 = new int[2*m];
        int [] dis = new int[n+1];
        int [] queue = new int[n];
        int cnt1 = 0;
        int cnt2 = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<m;j++) {
            des[j] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        while(k<=n) {
            arr1[k] = -1;
            k++;
        }
        int p= 0;
        while(p<=n) {
            dis[p] = -1;
            p++;
        }
        for(int l=0;l<m;l++) {
            arr3[cnt1] = des[l];
            arr2[cnt1] = arr1[src[l]];
            arr1[src[l]] = cnt1;
            cnt1++;
            arr3[cnt1] = src[l];
            arr2[cnt1] = arr1[des[l]];
            arr1[des[l]] = cnt1;
            cnt1++;
        }
        dis[d] = 0;
        queue[cnt2] = d;
        cnt2++;
        for(int x=0;x<cnt2;x++) {
              int n1 = queue[x];
              int w = arr1[n1];
              while(w!=-1) {
                int n2 = arr3[w];
                if(dis[n2]==-1) {
                    dis[n2] = dis[n1]+1;
                    queue[cnt2] = n2;
                    cnt2++;
                }
                w = arr2[w];
            }
        }
        if(dis[s]==-1){
            pw.println(-1);
        }
        else {
        pw.println(dis[s]);
        int cur = s;
        int z = 1;
        while(z>0) {
            pw.print(cur + " ");
            if(cur==d) {
                break;
            }
            int b = -1;
            int w1 = arr1[cur];
            while(w1!=-1) {
                int n3 = arr3[w1];
                if(dis[n3]==dis[cur]-1) {
                    if(b==-1||n3<b) {
                        b = n3;
                    }
                }
                w1 = arr2[w1];
            }
            cur = b;
            z++;
        }
    }
        pw.close();
    }
}
            
