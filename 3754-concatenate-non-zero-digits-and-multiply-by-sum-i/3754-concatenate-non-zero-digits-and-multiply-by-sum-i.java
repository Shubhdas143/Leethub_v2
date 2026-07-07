class Solution {
    public long sumAndMultiply(int n) {
        int mul = 1;
        int val = 0;
        long sum = 0;
        int v = n;

        while (v > 0) {
            int d = v % 10;
            sum += d;

            if (d != 0) {
                val = d * mul + val;
                mul *= 10;
            }

            v /= 10;
        }

        return sum * (long) val;
    }
}