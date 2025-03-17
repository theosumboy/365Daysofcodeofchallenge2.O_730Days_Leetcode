class Solution:
    def divideArray(self, nums: list[int]) -> bool:
        freq = Counter(nums)
        for count in freq.values():
            if count % 2 != 0:
                return False
        return True
