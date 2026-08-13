import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> counts = new TreeMap<>();

    private void addLen(int len) {
        if (len > 0) {
            counts.put(len, counts.getOrDefault(len, 0) + 1);
        }
    }

    private void removeLen(int len) {
        if (len > 0) {
            int count = counts.get(len);
            if (count == 1) {
                counts.remove(len);
            } else {
                counts.put(len, count - 1);
            }
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        int[] result = new int[k];
        char[] arr = s.toCharArray();

        TreeMap<Integer, Integer> segments = new TreeMap<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            int len = j - i;
            segments.put(i, len);
            addLen(len);
            i = j;
        }

        for (int q = 0; q < k; q++) {
            int idx = queryIndices[q];
            char c = queryCharacters.charAt(q);

            if (arr[idx] == c) {
                result[q] = counts.lastKey();
                continue;
            }

            Map.Entry<Integer, Integer> it = segments.floorEntry(idx);
            int start = it.getKey();
            int len = it.getValue();
            int end = start + len - 1;

            segments.remove(start);
            removeLen(len);

            int leftLen = idx - start;
            int rightLen = end - idx;

            if (leftLen > 0) {
                segments.put(start, leftLen);
                addLen(leftLen);
            }
            if (rightLen > 0) {
                segments.put(idx + 1, rightLen);
                addLen(rightLen);
            }

            arr[idx] = c;

            int newStart = idx;
            int newLen = 1;

            if (idx > 0) {
                Map.Entry<Integer, Integer> leftIt = segments.floorEntry(idx - 1);
                if (leftIt != null) {
                    int lStart = leftIt.getKey();
                    int lLen = leftIt.getValue();
                    if (lStart + lLen - 1 == idx - 1 && arr[lStart] == c) {
                        newStart = lStart;
                        newLen += lLen;
                        removeLen(lLen);
                        segments.remove(lStart);
                    }
                }
            }

            Integer rightKey = idx + 1;
            if (segments.containsKey(rightKey) && arr[rightKey] == c) {
                int rLen = segments.get(rightKey);
                newLen += rLen;
                removeLen(rLen);
                segments.remove(rightKey);
            }

            segments.put(newStart, newLen);
            addLen(newLen);

            result[q] = counts.lastKey();
        }

        return result;
    }
}