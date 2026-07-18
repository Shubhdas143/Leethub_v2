class Solution {
    public int findGCD(int[] nums) {
int smallest=Integer.MAX_VALUE,biggest=Integer.MIN_VALUE;
        for(int val:nums){
            if(val<smallest)smallest=val;
            if(val>biggest)biggest=val;
        }
        return gcd(smallest,biggest);
    }
    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}