#include <vector>
#include <unordered_set>
#include <string>
using namespace std;
/*
 * @lc app=leetcode.cn id=2306 lang=cpp
 *
 * [2306] 公司命名
 */

// @lc code=start

class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        unordered_set<string> groups[26];
        for(auto&s : ideas){
            groups[s[0] - 'a'].insert(s.substr(1));
        
        }
        long long ans = 0;
        for(int a = 1; a < 26; a++){
            for(int b = 0; b < a; b++){
                int m = 0;//a和b交集的大小
                for(auto&s : groups[a]){
                    m += groups[b].count(s);//元素是否在容器中，返回0或者1
                }
                 ans += (long long) (groups[a].size() - m) * (groups[b].size() - m);
            }
           
        }
        return ans * 2;

        
    }
};
// @lc code=end

/*
无效的名字发生的原因
1、除了首字母之外后面都相同，导致交换之后还是原来的两个单词
2、首字母相同，交换之后还是原来的两个单词
3、这一种是最普遍的，就是完全不相干的两个单词，但是交换之后跟另外一个单词一样，究其原因，还是coffee和toffee导致的*/

