class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<int> rooms(1, -1);
        for(int i = 0; i < intervals.size(); i++) {
            int idx = -1;
            for(int j = 0; j < rooms.size(); j++) {
                if(rooms[j] <= intervals[i][0]) {
                    idx = j;
                }
            }
            if(idx == -1)
                rooms.push_back(intervals[i][1]);
            else 
                rooms[idx] = intervals[i][1];
        }
        
        return rooms.size();
    }
};