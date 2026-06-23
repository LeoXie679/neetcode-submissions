class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        if(nums == null || nums.length <  1){
            return false;
        }
        seen.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(seen.contains(nums[i])) return true;
            seen.add(nums[i]);
        }

        return false;
    }
}