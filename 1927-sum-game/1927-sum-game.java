class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;
        
        // Single pass over both halves
        for (int i = 0; i < n / 2; i++) {
            char c1 = num.charAt(i);
            if (c1 == '?') {
                leftQ++;
            } else {
                leftSum += c1 - '0';
            }
            
            char c2 = num.charAt(i + n / 2);
            if (c2 == '?') {
                rightQ++;
            } else {
                rightSum += c2 - '0';
            }
        }
        
        // Bob wins if the missing sum can be perfectly balanced by pairs of 9s
        return (leftSum - rightSum) * 2 != (rightQ - leftQ) * 9;
    }
}