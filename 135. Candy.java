// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        int totalCandies = candies[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}