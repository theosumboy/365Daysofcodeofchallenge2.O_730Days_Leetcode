class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        
        if len(s) % 2 != 0:
            return False
        
        
        open_count = 0 
        flexible_count = 0 

        for char, lock in zip(s, locked):

            if lock == '0':  
                flexible_count += 1

            elif char == '(':
                open_count += 1

            else:  
                if open_count > 0:
                    open_count -= 1
                else:
                    flexible_count -= 1
            if flexible_count < 0:  
                return False
        
        
        close_count = 0
        flexible_count = 0
        for char, lock in zip(reversed(s), reversed(locked)):
            if lock == '0':  
                flexible_count += 1
            elif char == ')':
                close_count += 1
            else:  
                if close_count > 0:
                    close_count -= 1
                else:
                    flexible_count -= 1
            if flexible_count < 0:  
                return False
        
        
        return True
