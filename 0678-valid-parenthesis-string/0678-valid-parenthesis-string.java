class Solution {
    public boolean checkValidString(String s) {
        Boolean[][]arr=new Boolean[s.length()][s.length()+1];
        return helper(s,0,0,arr);
    }
    public static boolean helper(String s,int index,int sum,Boolean[][]dp){
        if(sum<0)return false;
        if(index>=s.length())return sum==0;
        if(dp[index][sum]!=null)return dp[index][sum];
        boolean result;
        if(s.charAt(index)=='('){
            result=helper(s,index+1,sum+1,dp);
        }else if(s.charAt(index)==')'){
            result=helper(s,index+1,sum-1,dp);
        }else{
            // three treatment (, ), ' '
            result=helper(s,index+1,sum+1,dp)||
                    helper(s,index+1,sum-1,dp)||
                    helper(s,index+1,sum,dp);
        }
        dp[index][sum]=result;
        return dp[index][sum];
    }
}