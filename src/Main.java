
import java.io.*;
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
        FastReader sc = new FastReader(new FileInputStream("src/input.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(sc.nextInt()  + "A");
        }
    }
}
