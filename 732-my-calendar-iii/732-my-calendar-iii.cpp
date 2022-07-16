class MyCalendarThree {
    map<int, int> schedule;
    
public:
    MyCalendarThree() {
        
    }
    
    int book(int start, int end) {
        schedule[start]++;
        schedule[end]--;
        int maxBookings = 0;
        int booking = 0;
        for(auto& s : schedule) {
            booking += s.second;
            maxBookings = max(maxBookings, booking);
        }
        return maxBookings;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */