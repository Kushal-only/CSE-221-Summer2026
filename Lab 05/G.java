import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[n+1];
        int [] arr2 = new int[m];
        int [] arr3 = new int[m];
        boolean flag = false;
        String [] color = new String[n+1];
        int [] a1 = new int[n+1];
        int [] a2 = new int[n+1];
        int cnt = 0;
        for(int i=0;i<=n;i++) {
            arr1[i] = -1;
        }
        for(int k=0;k<=n;k++) {
            color[k] = "wh";
        }
        for(int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            arr3[j] = des;
            arr2[j] = arr1[src];
            arr1[src] = j;
        }
        int l = 1;
        while(l<=n) {
            if(flag==true) {
                break;
            }
            if(color[l]=="wh") {
                a1[cnt] = l;
                a2[cnt] = arr1[l];
                color[l] = "gr";
                cnt++;
                while(cnt>0) {
                    if(flag==true) {
                        break;
                    }
                    int v = cnt-1;
                    int n1 = a1[v];
                    int w = a2[v];
                    if(w!=-1) {
                        a2[v] = arr2[w];
                        int n2 = arr3[w];
                        if(color[n2]=="gr") {
                            flag = true;
                        }
                        else if(color[n2]=="wh") {
                            color[n2] = "gr";
                            a1[cnt] = n2;
                            a2[cnt] = arr1[n2];
                            cnt++;
                        }
                    }
                    else {
                        color[n1] = "bl";
                        cnt--;
                    }
                }
            }
            l++;
        }
        if(flag==true) {
            pw.print("YES");
        }
        else {
            pw.print("NO");
        }
        pw.close();
    }
}
