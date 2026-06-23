class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> bank = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            int complement = target - currentNum;
            
            if(bank.containsKey(complement)){
                ans[1] = i;
                ans[0] = bank.get(complement);
            }
            bank.put(nums[i], i);
        }
        return ans;
    }
}
