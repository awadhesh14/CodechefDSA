import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

class FASHION {
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
        int t = sc.nextInt(),n;
        long ans;
        Vector<Integer> M,W;// = new Vector<>();
        StringBuilder str = new StringBuilder(2*t+2);
        while (t-- > 0) {
            n=sc.nextInt();
            ans=0;
            M = new Vector<>(n);W = new Vector<>(n);
            for(int i=0;i<n;i++)
                M.add(sc.nextInt());
            for(int i=0;i<n;i++)
                W.add(sc.nextInt());
            M.sort(Integer::compareTo);
            W.sort(Integer::compareTo);
            for (int i=0;i<n;i++)
                ans+= (W.get(i)*M.get(i));
            str.append(ans+"\n");
        }
        System.out.println(str);
    }
}
