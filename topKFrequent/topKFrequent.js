var topKFrequent = function(nums,k) {
    var dict = {};
    for(var n of nums) dict[n] = 0;
    for(var n of nums) dict[n]++;
    var items = Object.keys(dict).map(function(key) {return [key, dict[key]];});
    items.sort(function(first, second) {return second[1] - first[1];});
    var a = [];
    for(var i = 0; i < k; i++) a[i] = items[i][0];
    return a;
}
