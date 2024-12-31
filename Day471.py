class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        @lru_cache(None)
        def recur(idx):
            if idx == len(days):
                return 0
            dayPass = costs[0] + recur(idx + 1)
            weekPass = costs[1] + recur(bisect_left(days, days[idx] + 7))
            monthPass = costs[2] + recur(bisect_left(days, days[idx] + 30))
            return min(dayPass, weekPass, monthPass)
        return recur(0)
