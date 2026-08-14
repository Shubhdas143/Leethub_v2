class Solution {
    public int maximumLengthSubstring(String s) {
        int res=0;
        int low=0;
        HashMap<Character,Integer> h=new HashMap<>();
        for(int high=0;high<s.length();high++){
            char ch=s.charAt(high);
            h.put(ch,h.getOrDefault(ch,0)+1);
            while(h.get(ch)>2){
                char temp=s.charAt(low);
                h.put(temp,h.get(temp)-1);
                if(h.get(temp)==0)
                    h.remove(temp);
                low++;
            }
            res=Math.max(res,high-low+1);
        }
        return res;
    }
}