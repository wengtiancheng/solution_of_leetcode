/*
 * @lc app=leetcode.cn id=2286 lang=cpp
 *
 * [2286] 以组为单位订音乐会的门票
 */

// @lc code=start
#include <vector>
using namespace std;

class BookMyShow {
public:
   vector<int> pointer_of_each_row;
    int rows;
    int cols;

    BookMyShow(int n, int m) {
        rows = n;
        cols = m;
        pointer_of_each_row.resize(n, 0);
    }
    
    vector<int> gather(int k, int maxRow) {
        for (int i = 0; i <= maxRow && i < rows; ++i) {
            int start = pointer_of_each_row[i];
            if (start + k <= cols) {
                pointer_of_each_row[i] += k;
                return {i, start}; // 返回行和列
            }
        }
        return {}; // 找不到合适的座位
    }
    
    bool scatter(int k, int maxRow) {
        int totalAvailable = 0;
        for (int i = 0; i <= maxRow && i < rows; ++i) {
            totalAvailable += (cols - pointer_of_each_row[i]);
            if (totalAvailable >= k) {
                break;
            }
        }
        
        if (totalAvailable < k) {
            return false; // 不足以满足需求
        }

        for (int i = 0; i <= maxRow && i < rows; ++i) {
            while (pointer_of_each_row[i] < cols && k > 0) {
                pointer_of_each_row[i]++;
                k--;
            }
            if (k == 0) {
                return true; // 成功分配
            }
        }
        
        return false; // 未能分配所有座位
    }
};

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow* obj = new BookMyShow(n, m);
 * vector<int> param_1 = obj->gather(k,maxRow);
 * bool param_2 = obj->scatter(k,maxRow);
 */
// @lc code=end

