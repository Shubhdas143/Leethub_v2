class Solution {
    public int longestBalanced(String s) {
        
        int n=s.length();
         int ans=0;
        for(int i=0;i<n;++i)
        {
            int[]mpp=new int[26];
            for(int j=i;j<n;++j)
            {
                mpp[s.charAt(j)-'a']++;
                 int x=0;
            for(int k=0;k<26;++k)
            {
                if(mpp[k]!=0)
                {
                    x=mpp[k];
                    break;
                }
            }
            boolean ok=true;
             for(int k=0;k<26;++k)
            {
                if(mpp[k]!=0 && mpp[k]!=x)
                {
                  ok=false;
                  break;  
                }
            }
            if(ok)
            ans=Math.max(ans,j-i+1);
            }
           

        }
        return ans;
    }
}