/*TODO: I am skipping this*/
import java.io.*;
import java.util.*;

class Codechef {
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
        ArrayList<Integer> brr ;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (t-- > 0) {
            long extra= 0;
            int N = sc.nextInt();
            map.clear();
            for(int n=0;n<N;n++){
                int B = sc.nextInt(),L = sc.nextInt();
                if(map.containsKey(B)) {
                    if (map.get(B) > L) {
                        extra += map.get(B);
                        map.put(B, L);
                    }
                    else{
                        extra += L;
                    }
                }
                else {
                    map.put(B, L);
                }
                //arr.add(new Bands(B,L));
            }
            long ans = extra*map.size();
            int i=1;
            brr = new ArrayList<>(map.values());
            Collections.sort(brr);
            for(int j:brr){
                ans += i*j;
                i++;
            }
            System.out.println(ans);
        }
    }

}
