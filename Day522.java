

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> seen = new HashSet<>(Arrays.asList(nums));
        return generateBinaryString(nums.length, seen, new StringBuilder());
    }

    private String generateBinaryString(int n, Set<String> seen, StringBuilder curr) {
        if (curr.length() == n) {
            return seen.contains(curr.toString()) ? "" : curr.toString();
        }
        
        curr.append('0');
        String res = generateBinaryString(n, seen, curr);
        if (!res.isEmpty()) return res;
        
        curr.setCharAt(curr.length() - 1, '1');
        res = generateBinaryString(n, seen, curr);
        if (!res.isEmpty()) return res;
        
        curr.deleteCharAt(curr.length() - 1);
        return "";
    }
}
