class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='[')stack.push(c);
            else{
                if(c==')'&&!stack.isEmpty()&&stack.peek()!='(')return false;
                else if(c=='}'&&!stack.isEmpty()&&stack.peek()!='{')return false;
                else if(c==']'&&!stack.isEmpty()&&stack.peek()!='[')return false;
                else{
                    if(stack.isEmpty())return false;
                    else stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}