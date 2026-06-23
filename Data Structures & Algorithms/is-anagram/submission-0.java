class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null | t == null) return false;
        if(s.length() < 1 || t.length() < 1) return true;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        boolean areEqual = Arrays.equals(sArray, tArray);

        return areEqual;
    
    }
}
