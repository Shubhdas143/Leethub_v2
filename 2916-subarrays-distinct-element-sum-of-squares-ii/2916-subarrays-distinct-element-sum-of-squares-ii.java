class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] tree;
    private long[] treeSq;
    private long[] lazy;

    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            apply(leftChild, start, mid, lazy[node]);
            apply(rightChild, mid + 1, end, lazy[node]);

            lazy[node] = 0;
        }
    }

    private void apply(int node, int start, int end, long val) {
        long len = end - start + 1;
        val %= MOD;

        treeSq[node] = (treeSq[node] + 2 * val % MOD * tree[node] % MOD + len % MOD * (val * val % MOD) % MOD) % MOD;
        tree[node] = (tree[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int start, int end, int l, int r, long val) {
        if (r < start || end < l) {
            return;
        }
        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        update(2 * node, start, mid, l, r, val);
        update(2 * node + 1, mid + 1, end, l, r, val);

        tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        treeSq[node] = (treeSq[2 * node] + treeSq[2 * node + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new long[4 * n];
        treeSq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastPos = new HashMap<>();
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastPos.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i, 1);
            totalSum = (totalSum + treeSq[1]) % MOD;
            lastPos.put(nums[i], i);
        }

        return (int) totalSum;
    }
}