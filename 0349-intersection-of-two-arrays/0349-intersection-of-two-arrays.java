class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Initialize two pointers
        int N = nums1.length;
        int M = nums2.length;
        int p1 = 0;
        int p2 = 0;
        
        // Create set that stores integers appearing in both arrays
        Set<Integer> intersection = new HashSet<>();

        // Iterate the pointers from left to right
        while (p1 < N && p2 < M) {
            // Add a value to the set if values at both pointers equal
            if (nums1[p1] == nums2[p2]) {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            }
            // Otherwise, increment the pointer of the smaller integer
            else if (nums1[p1] < nums2[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }

        // Convert intersection to an array
        int K = intersection.size();
        int[] result = new int[K];
        int curr = 0;
        for (int x: intersection) {
            result[curr++] = x;
        }

        //Return the result
        return result;
    }
}