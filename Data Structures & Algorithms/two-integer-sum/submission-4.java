class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return null;
        HashMap<Integer, Integer> bank = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int corresponding = target - nums[i];

            if(bank.containsKey(corresponding)){
                int needed = bank.get(corresponding);
                int found = i;
                result[0] = needed;
                result[1] = found;
            }
            bank.put(nums[i], i);
        }
    return result;  
    }
}
