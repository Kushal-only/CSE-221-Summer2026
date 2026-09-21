import java.io.*;
import java.util.*;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int [] in = new int[l];
        int [] post = new int[l];
        int [] pre = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<l;j++) {
            post[j] = Integer.parseInt(st.nextToken());
        }
        preOrder(in,post,pre,0,l-1,l-1);
        for(int k=0;k<l;k++) {
            pw.print(pre[k] + " ");
        }
        pw.close();
    }
    static int preIdx = 0;
    public static void preOrder(int[] in,int [] post,int [] pre,int l,int r,int postIdx) {
        if(l>r) {
            return;
        }
        int root = post[postIdx];
        pre[preIdx] = root;
        preIdx++;
        int rootIdx = l;
        for(int k=l;k<=r;k++) {
            if(in[k]==root) {
            rootIdx = k;
            break;
            }
        }
        int s = r-rootIdx;
        preOrder(in,post,pre,l,rootIdx-1,postIdx-s-1);
        preOrder(in,post,pre,rootIdx+1,r,postIdx-1);
    }
}