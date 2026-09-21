import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int [] disX = {1,1,-1,-1,2,2,-2,-2};
        int [] disY = {2,-2,2,-2,1,-1,1,-1};
        int [][] dis = new int[n+1][n+1];
        int u = n*n;
        int [] q1 = new int[u];
        int [] q2 = new int[u];
        int cnt = 0;
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                dis[i][j] = -1;
            }
        }
        dis[x1][y1] = 0;
        q1[cnt] = x1;
        q2[cnt] = y1;
        cnt++;
        int k = 0;
        while(k<cnt) {
            int r = q1[k];
            int c = q2[k];
            if(r==x2) {
                if(c==y2) {
                    break;
                }
            }
            int l = 0;
            while(l<8) {
                int r1 = r+disX[l];
                int c1 = c+disY[l];
                if(r1>=1 && r1<=n) {
                    if(c1>=1 && c1<=n) {
                        if(dis[r1][c1]==-1) {
                            int v = dis[r][c]+1;
                            dis[r1][c1] = v;
                            q1[cnt] = r1;
                            q2[cnt] = c1;
                            cnt++;
                        }
                    }
                }
                l++;
            }
            k++;
        }
        pw.println(dis[x2][y2]);
        pw.close();
    }
}
