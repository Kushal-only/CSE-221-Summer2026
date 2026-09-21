import java.io.*;
import java.util.StringTokenizer;

public class ancientSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int l = Integer.parseInt(br.readLine());
        int [] arr = new int[l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int j=0;j<l-1;j++) {
            if(arr[j]%2==0 && arr[j+1]%2==0) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    j = -1;
                }
            }
            else if(arr[j]%2!=0 && arr[j+1]%2!=0) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    j = -1;
                }
            }
        }
        for(int k=0;k<l;k++) {
            pw.print(arr[k] + " ");
        }
        pw.close();
    }
}
