var lengthOfLIS = function(nums) {
    var LIS = new Array();  
    for(var i= 0; i < nums.length; i++) LIS[i] = 1;                         // initialize every entry as 1 
    var maxVal = 1;
    for(var j = nums.length - 1; j >= 0; j--){                              // traverse from end to beginning using         
        for (var k = j - 1; k >= 0; k--){                                   // previous values to update LIS list 
            if(nums[k] < nums[j]){
                LIS[k] = Math.max(LIS[k],1 + LIS[j]);
                if (LIS[k] > maxVal) maxVal = LIS[k];
            }
        }
    }
    return maxVal;                                                          // returns maximum # of subsequence
};
