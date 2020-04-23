/*Template for every code*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream x)
        {
            br = new BufferedReader(new InputStreamReader(x));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader(new FileInputStream("foundation/src/input.in"));
        int t = sc.nextInt();
        int j,n;
        Vector<Integer> arr = new Vector<>();

        while(t-->0){
            n = sc.nextInt();
            arr.clear();
            StringBuilder srr = new StringBuilder();
            for (int i=0;i<n;i++) {
                j = sc.nextInt();
                if (j==1) srr.append(1+" ");
                else arr.add(j);
            }
            arr.sort((p,q)->  q-p);
            if (arr.size()==2 && arr.get(0)==3 && arr.get(1)==2){
                Collections.swap(arr,0,1);
            }

            for(int i:arr)
                srr.append(i+" ");
            System.out.println(srr);
        }
    }
}
