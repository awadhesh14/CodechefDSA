/*Template for every code*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
        FastReader sc = new FastReader(System.in);
        int t = sc.nextInt();
        int N,K,T;
        long B;
        for(int _t=1;_t<=t;_t++){
            N=sc.nextInt();K=sc.nextInt();B=sc.nextLong();T=sc.nextInt();
            ArrayList<Integer> X = new ArrayList<>(N);
            for(int i=0;i<N;i++)
                X.add(sc.nextInt());
            ArrayList<Integer> V = new ArrayList<>(N);
            for(int i=0;i<N;i++)
                V.add(sc.nextInt());
            int k=0,jumps=0,stragglers=0;
            for (int i=N-1;i>=0;i--){
                if ((float)(B-X.get(i))/V.get(i) <= T) {
                    k++;
                    jumps += stragglers;
                }
                else stragglers++;
                if (k>=K) break;
            }
            if (k>=K)
                System.out.println("Case #"+_t+": "+jumps );
            else
                System.out.println("Case #"+_t+": "+"IMPOSSIBLE");
        }
    }
}
