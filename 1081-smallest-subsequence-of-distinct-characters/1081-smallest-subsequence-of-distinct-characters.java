class Solution {
    public String smallestSubsequence(String s) {
int[]lastIndexOfChar=new int[26];
        boolean[]visited=new boolean[26];
        Stack<Character>stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            lastIndexOfChar[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            char cur=s.charAt(i);
            if(visited[cur-'a'])continue;
            while(!stack.isEmpty()&&stack.peek()>cur&&lastIndexOfChar[stack.peek()-'a']>i){
                visited[stack.pop()-'a']=false;
            }
            stack.push(cur);
            visited[cur-'a']=true;
        }
        StringBuilder ans=new StringBuilder();
        for(char c:stack)ans.append(c);
        return ans.toString();
    }
}