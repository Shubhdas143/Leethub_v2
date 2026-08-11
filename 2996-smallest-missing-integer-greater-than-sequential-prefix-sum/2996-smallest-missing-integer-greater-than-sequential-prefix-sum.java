class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        boolean[] hashTable = new boolean[1276];

        int sequentialSum = nums[0];
        for(int i = 0; i < n; i++){
            hashTable[nums[i]] = true;
        }
        for(int i = 1;
            i < n && nums[i] == nums[i - 1] + 1;
            sequentialSum += nums[i++]);
        while(hashTable[sequentialSum])
            sequentialSum++;
            

        return sequentialSum;
    }
}