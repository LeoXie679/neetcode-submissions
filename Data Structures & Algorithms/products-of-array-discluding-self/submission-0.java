class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<Integer> currResult = new ArrayList<>();
        for(int numbers : nums){
            curr.add(numbers);
        }
        for(int i = 0; i < curr.size(); i++){
            int removed = curr.remove(i);
            int product = curr.stream().reduce(1, (a, b) -> a * b);
            currResult.add(i, product);
            curr.add(i, removed);
        }
        result = currResult.stream().mapToInt(Integer::intValue).toArray();
        return result;
        
    }
}  
