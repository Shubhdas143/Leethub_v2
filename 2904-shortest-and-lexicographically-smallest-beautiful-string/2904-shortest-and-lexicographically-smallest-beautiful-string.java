class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = 0;
        int count = 0;
        int[] smallest = new int[3];

        for (int i = 0; i < s.length(); i++) {
            end++;

            if (sChar[i] == '1') {
                count++;
            }

            while (count >= k && start < end) {

                if (smallest[0] == 0 || (end - start) < smallest[0]) {
                    smallest[0] = end - start;
                    smallest[1] = start;
                    smallest[2] = end;
                } else if ((end - start) == smallest[0]) {

                    String previousSubString =
                            s.substring(smallest[1], smallest[2]);

                    String currentSubString =
                            s.substring(start, end);

                    if (isCurrentSmaller(previousSubString, currentSubString)) {
                        smallest[0] = end - start;
                        smallest[1] = start;
                        smallest[2] = end;
                    }
                }

                if (sChar[start] == '1') {
                    count--;
                }

                start++;
            }
        }

        return s.substring(smallest[1], smallest[2]);
    }

    private boolean isCurrentSmaller(String previousSubString,
                                     String currentSubString) {

        for (int i = 0; i < currentSubString.length(); i++) {

            if (previousSubString.charAt(i)
                    < currentSubString.charAt(i)) {
                return false;
            } else if (previousSubString.charAt(i)
                    > currentSubString.charAt(i)) {
                return true;
            }
        }

        return true;
    }
}