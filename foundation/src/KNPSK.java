
import java.io.*;
import java.util.*;

class KNPSK {
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
        int t = sc.nextInt(),w,c,W = 0;
        boolean single;
        ArrayList<Integer> arr = new ArrayList<>(t),brr = new ArrayList<>(t);
        Stack<Integer> a=new Stack<>(),b = new Stack<>();
        while (t-- > 0) {
            w=sc.nextInt();c=sc.nextInt();
            if (w==1) arr.add(c);
            else  brr.add(c);
            W += w;
        }
        long[] res = new long[W+1];
        arr.sort(Comparator.comparingInt(p -> p));
        brr.sort(Comparator.comparingInt(p -> p));
        /*brr.forEach(s -> System.out.println(s+ " "));*/
        a.addAll(arr);b.addAll(brr);
        /*even*/
        int costa,costb;
        long ans=0;
        for(int i=2;i<=W;i+=2){
            costa=0;costb=0;
            single=false;
            if(a.size()>=2){
                costa = a.peek()+a.elementAt(a.size()-2);
            }
            else if(a.size()==1){
                costa = a.peek();
                single = true;
            }
            if(!b.empty()){
                costb = b.peek();
            }
            if(costa>costb){
                if(single){
                    a.pop();
                }
                else {
                    a.pop();a.pop();
                }
                ans += costa;
            }
            else{
                b.pop();
                ans+=costb;
            }
            res[i] = ans;
        }
        /*odd*/
        a.addAll(arr);b.addAll(brr);
        ans=0;
        if(!a.empty()){
            ans=a.peek();
            res[1]=a.pop();
        }
        else{
            res[1]=0;
        }
        for(int i=3;i<=W;i+=2){
            costa=0;costb=0;
            single=false;
            if(a.size()>=2){
                costa = a.peek()+a.elementAt(a.size()-2);
            }
            else if(a.size()==1){
                costa = a.peek();
                single = true;
            }
            if(!b.empty()){
                costb = b.peek();
            }
            if(costa>costb){
                if(single){
                    a.pop();
                }
                else {
                    a.pop();a.pop();
                }
                ans += costa;
            }
            else{
                b.pop();
                ans+=costb;
            }
            res[i] = ans;
        }
        for(int i=1;i<=W;i++)
            System.out.print(res[i]+" ");
    }

}
