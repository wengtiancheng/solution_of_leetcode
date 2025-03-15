using namespace std;
/*
 * @lc app=leetcode.cn id=203 lang=cpp
 *
 * [203] 移除链表元素
 */

// @lc code=start

// struct ListNode {
//      int val;
//         ListNode *next;
//       ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//       ListNode(int x, ListNode *next) : val(x), next(next) {}
// };

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
       
        ListNode* ptr = head;
        while(ptr != nullptr && ptr->val == val){
            ptr = ptr->next;
        }
        if(ptr == nullptr){
            return nullptr;
        }
        ListNode* res = ptr;
        ListNode* ptr_next = ptr->next;
        while(ptr_next != nullptr){
            if(ptr_next->val == val){
                ptr->next = ptr_next->next;
                ptr_next = ptr->next;
                
            }else{
                ptr = ptr->next;
                ptr_next = ptr->next;
            }
            
        }
        return res;
    }
        
        

    
};
// @lc code=end

