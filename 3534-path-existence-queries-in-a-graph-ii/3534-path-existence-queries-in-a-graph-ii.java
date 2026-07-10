class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int LOG = 18;

        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = nums[i];
            vec[i][1] = i;
        }

        Arrays.sort(vec, (a, b) -> {
            if (a[0] != b[0]) 
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] getSortIdx = new int[n];
        for (int i = 0; i < n; i++) {
            getSortIdx[vec[i][1]] = i;
        }

        int[][] st = new int[n][LOG];
        int l = 0;

        for (int r = 0; r < n; r++) {
            while (vec[r][0] - vec[l][0] > maxDiff) {
                st[l][0] = r - 1;
                l++;
            }
        }

        while (l < n) {
            st[l][0] = n - 1;
            l++;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = st[st[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < queries.length; i++) {
            int a = getSortIdx[queries[i][0]];
            int b = getSortIdx[queries[i][1]];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a == b) {
                ans[i] = 0;
                continue;
            }

            int cur = a;
            int step = 0;

            for (int j = LOG - 1; j >= 0; j--) {
                if (st[cur][j] < b) {
                    step += 1 << j;
                    cur = st[cur][j];
                }
            }

            if (st[cur][0] >= b) {
                ans[i] = step + 1;
            }
        }

        return ans;
    }
}