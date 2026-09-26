class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> item:knowledge) {
            map.put(item.get(0),item.get(1));
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while(s.charAt(i)!=')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(sb.toString())) {
                    ans.append(map.get(sb.toString()));
                }else{
                    ans.append('?');
                }
            }else
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}