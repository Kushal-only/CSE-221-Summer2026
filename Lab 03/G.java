import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int [] in = new int[l];
        int [] pre = new int[l];
        int [] post = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<l;j++) {
            pre[j] = Integer.parseInt(st.nextToken());
        }
        postOrder(in,pre,post,0,l-1);
        for(int k=0;k<l;k++) {
            pw.print(post[k] + " ");
        }
        pw.close();
    }
    static int preIdx = 0;
    static int postIdx = 0;
    public static void postOrder(int[] in,int[] pre,int [] post,int l,int r) {
        if(l>r) {
            return;
        }
        int root = pre[preIdx];
        preIdx++;
        int rootIdx = l;
        for(int k=l;k<=r;k++) {
          if(in[k]==root) {
            rootIdx = k;
            break;
          }
        }
        postOrder(in,pre,post,l,rootIdx-1);
        postOrder(in,pre,post,rootIdx+1,r);
        post[postIdx] = root;
        postIdx++;
    }
}
