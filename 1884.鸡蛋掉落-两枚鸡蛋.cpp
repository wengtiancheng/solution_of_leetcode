/*
 * @lc app=leetcode.cn id=1884 lang=cpp
 *
 * [1884] 鸡蛋掉落-两枚鸡蛋
 */

// @lc code=start
class Solution {
public:
    int twoEggDrop(int n) {
        int sum = 0;
        int height = n;
        int ad = 1;
        while(height > 0){
            height -= ad;
            ad++;
            sum++;
        }
        return sum;

    }
};
// @lc code=end

