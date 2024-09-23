public class Solution {
    public int minExtraChar(String s, String[] d) {
        List<String> list = new ArrayList<>();
        for (String i : d) list.add(i);  // Convert dictionary array to a list for faster lookup.
        
        // Create a map to store memoized results
        HashMap<String, Integer> map = new HashMap<>();
        
        // Start recursion at index 0, with an empty temporary string
        return helper(s, list, 0, "", map);
    }
    
    int helper(String s, List<String> list, int ind, String temp, HashMap<String, Integer> map) {
        if (ind >= s.length()) return temp.length();  // If the string has been fully processed, return the length of any remaining extra characters.

        String chk = String.valueOf(ind) + " " + temp;  // Memoization key based on current index and temp string
        if (map.containsKey(chk)) return map.get(chk);  // Return memoized result if exists

        // Build the current substring by adding the current character
        String st = temp + s.charAt(ind);

        int inlist = Integer.MAX_VALUE;
        int notinlist = Integer.MAX_VALUE;

        // Case 1: Current substring `st` is in the dictionary
        if (list.contains(st)) {
            inlist = Math.min(
                Math.min(helper(s, list, ind + 1, "", map), // Reset temp and continue
                         helper(s, list, ind + 1, st, map)), // Keep building
                1 + helper(s, list, ind + 1, temp, map));  // Skip current character and count it as extra
        }

        // Case 2: Current substring is not in the dictionary
        notinlist = Math.min(
            Math.min(st.length() + helper(s, list, ind + 1, "", map), // Count `st` as extra and reset
                     helper(s, list, ind + 1, st, map)), // Continue adding to temp
            temp.length() + helper(s, list, ind + 1, String.valueOf(s.charAt(ind)), map)); // Add extra and move forward

        // Memoize the result
        map.put(chk, Math.min(inlist, notinlist));
        return Math.min(inlist, notinlist);
    }
}
