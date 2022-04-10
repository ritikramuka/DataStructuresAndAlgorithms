class Solution {
public:
    int calPoints(vector<string>& ops) {
        stack<int> st;
        int sum = 0;
        for(int i = 0; i < ops.size(); i++) {
            string str = ops[i];
            if(str == "+") {
                int p1 = st.top(); st.pop();
                int p2 = st.top(); st.pop();
                st.push(p2);
                st.push(p1);
                st.push(p1 + p2);
            } else if(str == "D") {
                int p = st.top();
                st.push(p * 2);
            } else if(str == "C") {
                sum -= st.top();
                st.pop();
                continue;
            } else {
                st.push(stoi(str));
            }
            sum += st.top();
        }
        return sum;
    }
};