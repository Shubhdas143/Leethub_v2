class Solution {
    private long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public String smallestNumber(String num, long t) {
        char[] c = num.toCharArray();
        int n = c.length;
        long[] remind = new long[n+1];
        remind[0] = t;
        int end = n;
        for (int i=0; i<n; i++) {
            if (c[i] == '0') {
                end = i + 1;
                break;
            }
            remind[i + 1] = remind[i] / gcd(remind[i], c[i] - '0');
        }
        if(end == n && remind[n] == 1) return num;
        for(int i=end-1; i>=0; i--) {
            while(c[i] < '9') {
                long tt = remind[i];
                c[i]++;
                tt /= gcd(tt, c[i] - '0');
                for (int j=n-1; j>i; j--) {
                    for (int k=9; k>0; k--) {
                        if (tt % k == 0) {
                            tt /= k;
                            c[j] = (char) ('0' + k);
                            break;
                        }
                    }
                }
                if (tt == 1) return new String(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; t>1 && i>1; i--) {
            while(t % i == 0) {
                sb.append(i);
                t /= i;
            }
        }
        if(t != 1) return "-1";
        String res = sb.reverse().toString();
        if(check(res, num)) return res;
        if(res.length() == num.length()) return "1" + res;
        int dif = num.length() - res.length();
        if(check( "1".repeat(dif) + res, num)) return "1".repeat(dif) + res;
        return "1".repeat(dif+1) + res;
    }
    
    boolean check(String a, String b) {
        if(a.length() > b.length()) return true;
        if(a.length() < b.length()) return false;
        return a.compareTo(b) > 0;
    }
}