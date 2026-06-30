class Solution {
    public int numberOfSubstrings(String s) {
        int result = 0;
        int left = 0;
        int countChar[] = new int[3];
        for(int right = 0; right < s.length(); right++){
            countChar[s.charAt(right) - 'a']++;
            while(countChar[0] > 0 && countChar[1] > 0 && countChar[2] > 0){
                result += s.length() - right;
                countChar[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}