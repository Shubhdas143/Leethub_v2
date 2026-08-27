public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        if (dfs(0, freq, sb, target, false)) {
            return sb.toString();
        }
        return "";
    }
    private boolean dfs(int i, int[] freq, StringBuilder sb, String target, boolean check) {
        if (i == target.length()) {
            return check;
        }
        for (int j = 0; j < 26; j++) {
            if (freq[j] == 0) continue;
            char candidate = (char) ('a' + j);
            if (!check && candidate < target.charAt(i)) continue;
            freq[j]--;
            sb.append(candidate);
            boolean nextCheck = check || candidate > target.charAt(i);
            if (dfs(i + 1, freq, sb, target, nextCheck)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            freq[j]++;
        }
        return false;
    }
}