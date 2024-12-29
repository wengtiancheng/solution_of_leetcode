/*
 * @lc app=leetcode.cn id=1366 lang=cpp
 *
 * [1366] 通过投票对团队排名
 */

// @lc code=start
#include <string>
#include <vector>
#include <unordered_map>
#include <cmath>
#include <algorithm>
using namespace std;
class Solution {
public:
    string rankTeams(vector<string>& votes) {
        int num_of_votes = votes.size();
        int num_of_teams = votes[0].size();
        
        // 存储每个队伍在各个位置上的得票数
        unordered_map<char, vector<int>> rank_counts;
        
        // 初始化每个队伍的得票数
        for (int i = 0; i < num_of_teams; i++) {
            rank_counts[votes[0][i]] = vector<int>(num_of_teams, 0);
        }
        
        // 累加每个队伍在各个位置上的得票数
        for (int i = 0; i < num_of_votes; i++) {
            for (int j = 0; j < num_of_teams; j++) {
                rank_counts[votes[i][j]][j] += 1;
            }
        }
        
        // 将队伍及其得票数转化为vector<pair<char, vector<int>>>
        vector<pair<char, vector<int>>> teams(rank_counts.begin(), rank_counts.end());
        
        // 按照排位的得票数进行排序
        sort(teams.begin(), teams.end(), [](const pair<char, vector<int>>& a, const pair<char, vector<int>>& b) {
            // 比较各个位置的得票数
            for (int i = 0; i < a.second.size(); i++) {
                if (a.second[i] != b.second[i]) {
                    return a.second[i] > b.second[i]; // 大的排前面
                }
            }
            // 如果所有位置的得票数相同，按字母顺序排序
            return a.first < b.first;
        });
        
        // 构建排名字符串
        string result;
        for (const auto& team : teams) {
            result += team.first;
        }
        
        return result;
    }
};
// @lc code=end

