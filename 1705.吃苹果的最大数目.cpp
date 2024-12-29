/*
 * @lc app=leetcode.cn id=1705 lang=cpp
 *
 * [1705] 吃苹果的最大数目
 */

// @lc code=start
#include <vector>
#include <queue>
#include <tuple>
using namespace std;
class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        int n = apples.size();
        priority_queue<tuple<int,int>, vector<tuple<int, int>>, greater<tuple<int, int>>> pq;
        int sum = 0;

        for(int day = 0; day < n || !pq.empty(); day++){
            if(day < n && apples[day] > 0){
                pq.push({day + days[day], apples[day]});
            }
            //清理掉已经过期的苹果
            while(!pq.empty() && get<0>(pq.top()) <= day){
                pq.pop();
            }

            //从队列中弹出最快过期的苹果
            if(!pq.empty()){
                auto [expiry, count] = pq.top();
                pq.pop();
                sum++;

                //如果还有苹果没有吃完，再放回队列中
                if(count > 1){
                    pq.push({expiry, count - 1});
                }
            }
        }
        return sum;
    }
};
// @lc code=end

