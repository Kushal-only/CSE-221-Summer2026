import java.io.*;
import java.util.StringTokenizer;

public class sortingAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<t;i++) {
            int count = 0;
            int l = Integer.parseInt(br.readLine());
            int [] id = new int[l];
            int [] marks = new int[l];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<l;j++) {
                id[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<l;k++) {
                marks[k] = Integer.parseInt(st.nextToken());
            }
            for(int m=0;m<l;m++) {
                int idx = m;
                for(int n=m+1;n<l;n++) {
                    if(marks[idx]<marks[n]) {
                        idx = n;
                    }
                    else if(marks[idx]==marks[n]) {
                        if(id[idx]>id[n]) {
                            idx = n;
                        }
                    }
                }
                if(idx!=m) {
                        int t1 = marks[m];
                        marks[m] = marks[idx];
                        marks[idx] = t1;
                        int t2 = id[m];
                        id[m] = id[idx];
                        id[idx] = t2;
                        count++;
                    }
                }
                pw.println("Minimum swaps: " + count);
                for(int y=0;y<l;y++) {
                    pw.println("ID: " + id[y] + " Mark: " + marks[y]);
                }
            }
            pw.close();
        }
    }
