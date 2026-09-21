import java.io.*;
import java.util.*;

public class H {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        String [][] arr = new String[r][h];
        int [][] visited = new int[r][h];
        int [] q1 = new int[r*h];
        int [] q2 = new int[r*h];
        int cnt = 0;
        for(int i=0;i<r;i++) {
            String n = br.readLine();
            for(int j=0;j<h;j++) {
                arr[i][j] = String.valueOf(n.charAt(j));
            }
        }
        for(int k=0;k<r;k++) {
            for(int l=0;l<h;l++) {
                if(!arr[k][l].equals("#") && visited[k][l]==0) {
                    int dia = 0;
                    int b = 0;
                    visited[k][l] = 1;
                    q1[b] = k;
                    q2[b] = l;
                    b++;
                    int p = 0;
                    while(p<b) {
                        int r1 = q1[p];
                        int c1 = q2[p];
                        if(arr[r1][c1].equals("D")) {
                            dia++;
                        }
                        if(c1>0) {
                            if(visited[r1][c1-1]==0) {
                                if(!arr[r1][c1-1].equals("#")) {
                                    visited[r1][c1-1] = 1;
                                    q1[b] = r1;
                                    q2[b] = c1-1;
                                    b++;
                                }
                            }
                        }
                        if(c1<h-1) {
                            if(visited[r1][c1+1]==0) {
                                if(!arr[r1][c1+1].equals("#")) {
                                    visited[r1][c1+1] = 1;
                                    q1[b] = r1;
                                    q2[b] = c1+1;
                                    b++;
                                }
                            }
                        }
                        if(r1>0) {
                            if(visited[r1-1][c1]==0) {
                                if(!arr[r1-1][c1].equals("#")) {
                                    visited[r1-1][c1] = 1;
                                    q1[b] = r1-1;
                                    q2[b] = c1;
                                    b++;
                                }
                            }
                        }
                        if(r1<r-1) {
                            if(visited[r1+1][c1]==0) {
                                if(!arr[r1+1][c1].equals("#")) {
                                    visited[r1+1][c1] = 1;
                                    q1[b] = r1+1;
                                    q2[b] = c1;
                                    b++;
                                }
                            }
                        }
                        p++;
                    }
                    if(dia>cnt) {
                        cnt = dia;
                    }
                }
            }
        }
        pw.print(cnt);
        pw.close();
    }
}
