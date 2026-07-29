class Solution {
    // Safely calculates (base * multiplier) / divisor without overflow.
    private long calcNextPermCnt(long base, long mult, long div) {
        long gcdVal = gcd(base, div);
        return (base / gcdVal) * (mult / (div / gcdVal));
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String smallestPalindrome(String str, long targetRank) {
        int len = str.length();

        // Handle trivial lengths directly without further processing.
        if (len <= 3) {
            return targetRank > 1 ? "" : str;
        }

        int halfLen = len / 2;
        char[] sArr = str.toCharArray();
        int[] chrPairCnts = new int[26];

        // Count character frequencies for the first half of the string.
        for (int i = 0; i < halfLen; i++) {
            chrPairCnts[sArr[i] - 'a']++;
        }

        long trgtRnk = targetRank;
        long curPermCnt = 1;
        long sufLen = 0;
        int splitChrPrefCnt = 0;
        int splitIdx = 26;
        boolean isThresholdReached = false;

        for (int chrIdx = 25; chrIdx >= 0; chrIdx--) {
            for (int step = 1; step <= chrPairCnts[chrIdx]; step++) {
                sufLen++;
                
                curPermCnt = calcNextPermCnt(curPermCnt, sufLen, step);

                if (curPermCnt >= trgtRnk) {
                    splitChrPrefCnt = chrPairCnts[chrIdx] - step;
                    splitIdx = chrIdx;
                    isThresholdReached = true;
                    break;
                }
            }
            if (isThresholdReached) break;
        }
        if (curPermCnt < trgtRnk) {
            return "";
        }

        int outIdx = 0;
        for (int chrIdx = 0; chrIdx <= splitIdx; chrIdx++) {
            int chrCntToPlace = (chrIdx == splitIdx) ? 
                splitChrPrefCnt : chrPairCnts[chrIdx];
                
            for (int i = 0; i < chrCntToPlace; i++) {
                sArr[outIdx++] = (char) (chrIdx + 'a');
            }
            chrPairCnts[chrIdx] -= chrCntToPlace;
        }
        while (sufLen > 0) {
            for (int chrIdx = splitIdx; chrIdx < 26; chrIdx++) {
                if (chrPairCnts[chrIdx] == 0) continue;
                long permsWithChr = calcNextPermCnt(
                    curPermCnt, chrPairCnts[chrIdx], sufLen
                );

                if (permsWithChr < trgtRnk) {
                    trgtRnk -= permsWithChr;
                    continue;
                }

                curPermCnt = permsWithChr;
                chrPairCnts[chrIdx]--;
                sufLen--;
                sArr[outIdx++] = (char) (chrIdx + 'a');
                break;
            }
        }
        for (int i = 0; i < halfLen; i++) {
            sArr[len - 1 - i] = sArr[i];
        }

        return new String(sArr);
    }
}