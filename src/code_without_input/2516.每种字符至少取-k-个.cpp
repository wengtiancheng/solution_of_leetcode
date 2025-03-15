/*
 * @lc app=leetcode.cn id=2516 lang=cpp
 *
 * [2516] 每种字符至少取 K 个
 */

// @lc code=start
#include <string>
#include <algorithm>
using namespace std;
class Solution {
public:
    int takeCharacters(string s, int k) {
        if(k == 0){
            return 0;
        }
        int count_a = count(s.begin(), s.end(), 'a');
        int count_b = count(s.begin(), s.end(), 'b');
        int count_c = count(s.begin(), s.end(), 'c');
        if(count_a < k || count_b < k || count_c < k){
            return -1;
        }else{
            int left = s.size() - 1;
            int min = left + 1;
            int right = s.size() - 1;
            while(left >= 0){
                
                if(s[left] == 'a'){
                    count_a--;
                }else if(s[left] == 'b'){
                    count_b--;
                }else{
                    count_c--;
                }
                left--;
                if(count_a >= k && count_b >= k && count_c >= k){
                
                }else{
                    while(right > left){
                        if(s[right] == 'a'){
                            count_a++;
                        }else if(s[right] == 'b'){
                            count_b++;
                        }else{
                            count_c++;
                        }
                        right--;
                        if(count_a >= k && count_b >= k && count_c >= k){
                            break;
                        }
                        
                    }
                }
                min = left + s.size() - right < min ? left + s.size()  - right : min;

            }
            return min;
            
            

        }
        
    }

 
};
// @lc code=end

