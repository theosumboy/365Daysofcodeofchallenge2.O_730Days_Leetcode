class Solution(object):
    def coloredCells(self, n):
        return 1+4*((n-1)*n//2)
