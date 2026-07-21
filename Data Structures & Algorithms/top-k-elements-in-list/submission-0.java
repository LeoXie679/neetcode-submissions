class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // ---- Step 1: count how many times each number appears ----
        // map holds  number -> its frequency,  e.g. [1,2,2,3,3,3] -> {1:1, 2:2, 3:3}
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            // getOrDefault(n, 0): current count for n, or 0 if never seen.
            // add 1, put it back. (Integer is immutable, so we must re-put — can't mutate in place.)
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // ---- Step 2: pull the distinct numbers into a list we can reorder ----
        // keySet() is a live view backed by the map and can't be sorted directly,
        // so copy it into our own independent ArrayList.
        List<Integer> keys = new ArrayList<>(map.keySet());

        // ---- Step 3: sort those numbers by frequency, highest first ----
        // The lambda is the comparison rule. For any two numbers a and b, we don't
        // compare a and b directly — we look up each one's COUNT in the map and
        // compare those. b - a makes it descending (biggest count first).
        keys.sort((a, b) -> map.get(b) - map.get(a));

        // ---- Step 4: take the first k numbers (already the k most frequent) ----
        // keys is now sorted most-frequent-first, so the answer is just the front k.
        // Copy into an int[] because the method returns int[], not List<Integer>.
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = keys.get(i);   // keys.get(i) is a NUMBER (a key), not a count
        }

        return result;   // <-- you were missing this line
    }
}