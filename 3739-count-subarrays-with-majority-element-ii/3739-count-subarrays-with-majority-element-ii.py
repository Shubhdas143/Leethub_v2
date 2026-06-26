class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        size = len(nums)
        pref = size

        freq = [0] * (2 * size + 1)
        freq[size] = 1

        less, ans = 0, 0

        for num in nums:
            if num == target:
                less += freq[pref]
                pref += 1
            else:
                pref -= 1
                less -= freq[pref]

            freq[pref] += 1
            ans += less

        return ans