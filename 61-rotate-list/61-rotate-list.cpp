/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int length(ListNode* head) {
        int len = 0;
        while(head) {
            head = head->next;
            len++;
        }
        
        return len;
    }
    
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == nullptr)
            return nullptr;
        
        int len = length(head);
        k = k % len;
        if(k == 0)
            return head;
        
        int st = len - k - 1;
        ListNode* curr = head;
        while(st-->0) {
            curr = curr->next;
        }
        
        ListNode* tail = curr;
        while(tail->next) {
            tail = tail->next;
        }
        
        tail->next = head;
        ListNode* newHead = curr->next;
        curr->next = nullptr;
        
        return newHead;
    }
};