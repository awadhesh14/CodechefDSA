import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class FGFS {
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
        int t = sc.nextInt(),N,K,count;
        ArrayList<Customer> arr = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap();
        while (t-- > 0) {
            N = sc.nextInt();K=sc.nextInt();
            arr.clear();
            for (int i=0;i<N;i++){
                arr.add(new Customer(sc.nextInt(),sc.nextInt(),sc.nextInt()));
            }
            Collections.sort(arr);
            /*arr.forEach(f -> System.out.println(f.start+" "+f.end+" "+f.preference));
            System.out.println();*/
            map.clear();
            count = 0;
            for(int i=0;i<N;i++) {
                if (map.containsKey(arr.get(i).preference)){
                    if (map.get(arr.get(i).preference) <= arr.get(i).start) {
                        map.put(arr.get(i).preference, arr.get(i).end);
                        count++;
                    }
                }
                else {
                    map.put(arr.get(i).preference,arr.get(i).end);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    static class Customer implements Comparable<Customer>{
        int start,end,preference;

        public Customer(int start, int end, int preference) {
            this.start = start;
            this.end = end;
            this.preference = preference;
        }

        @Override
        public int compareTo(Customer a) {
            if (end<a.end)
                return -1;
            else if (end>a.end)
                return 1;
            else return 0;
        }
    }
}
