
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }

        String t = "1" + s + "1";

        int m = t.length();
        char[] type = new char[m];
        int[] len = new int[m];
        int runs = 0;

        int i = 0;
        while (i < m) {
            char c = t.charAt(i);
            int j = i;
            while (j < m && t.charAt(j) == c) j++;
            type[runs] = c;
            len[runs] = j - i;
            runs++;
            i = j;
        }

        int maxGain = 0;

        for (i = 1; i < runs - 1; i++) {
            if (type[i] == '1' && type[i - 1] == '0' && type[i + 1] == '0') {
                int gain = len[i - 1] + len[i + 1];
                if (gain > maxGain) maxGain = gain;
            }
        }

        return ones + maxGain;
    }
}
