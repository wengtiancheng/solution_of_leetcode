/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

// 自定义哈希函数
struct VectorHash {
    size_t operator()(const vector<int>& v) const {
        size_t seed = v.size();
        for (const auto& i : v) {
            seed ^= hash<int>{}(i) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
        }
        return seed;
    }
};

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // 使用自定义哈希函数
        unordered_map<vector<int>, vector<string>, VectorHash> res;
        for (const string& str : strs) {
            res[process(str)].push_back(str);
        }

        vector<vector<string>> tmp;
        for (const auto& pair : res) {
            tmp.push_back(pair.second);
        }
        return tmp;
    }

    vector<int> process(const string& str) {
        vector<int> res(26, 0);
        for (char c : str) {
            res[c - 'a']++;
        }
        return res;
    }
};
// @lc code=end

