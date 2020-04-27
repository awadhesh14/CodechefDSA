/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.min;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
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
    static int func(int h,int[] krr,int i,int[][] dp){
        if(h==0)
            return 0;
        if (h<0)
            return MAXI;
        if (i>=krr.length && h>0)
            return MAXI;
        if (dp[h][i]!=-1)
            return dp[h][i];
        else {
            dp[h][i] = min(1 + func(h-krr[i],krr,i,dp), func(h,krr,i+1,dp));
            return dp[h][i];
        }

    }
    static int MAXI = 999999999;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader(System.in);
        int t = sc.nextInt();
        int n,ans;
        while(t-->0){
            n = sc.nextInt();
            int[] hrr = new int[n];
            int[] krr = new int[n];
            for(int i=0;i<n;i++)
                hrr[i] = 2*sc.nextInt();
            for(int i=0;i<n;i++)
                krr[i] = sc.nextInt();
            int[][] dp = new int[1002][1002];
            for (int i=0;i<1002;i++) {
                for (int j = 0; j < 1002; j++)
                    dp[i][j] = -1;
            }
            ans = 0;
            for (int i=0;i<n;i++){
                ans+=func(hrr[i],krr,0,dp);
                // System.out.println(ans);
            }
            System.out.println(ans);
        }
    }
}
