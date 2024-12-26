/*
 * @lc app=leetcode.cn id=2073 lang=cpp
 *
 * [2073] 买票需要的时间
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int len = tickets.size();
        int num = tickets[k];
        int sum = 0;
        for(int i = 0; i < k; i++){
            if(tickets[i] <= num){
                sum += tickets[i];
            }else{
                sum += num;
            }
        }
        sum += num;
        for(int i = k + 1; i < len; i++){
            if(tickets[i] < num){
                sum += tickets[i];
            }else{
                sum += num - 1;
            }
        }
        return sum;
        
    }
};
// @lc code=end

