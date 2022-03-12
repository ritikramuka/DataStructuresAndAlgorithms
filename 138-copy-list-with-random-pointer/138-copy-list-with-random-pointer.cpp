/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        // step 1 -> making copy of each node next to it
        // eg. X -> Y -> Z (given LL)
        // then, X -> X' -> Y -> Y' -> Z -> Z'
        
        Node* curr = head;
        while(curr != nullptr) {
            Node* temp = curr->next;
            curr->next = new Node(curr->val);
            curr->next->next = temp;
            curr = curr->next->next;
        }
        
        
        // step 2 -> copying random pointer, to the copy while traversing on alternative nodes
        
        curr = head;
        while(curr != nullptr) {
            if(curr->random != nullptr) {
                curr->next->random = curr->random->next;
            }
            curr = curr->next->next;
        }
        
        
        // step 3 -> getting copy from the LL
        
        Node* copy = new Node(-1);
        curr = copy;
        while(head != nullptr) {
            curr->next = head->next;
            curr = curr->next;
            head->next = head->next->next;
            head = head->next;
        }
        
        return copy->next;
    }
};