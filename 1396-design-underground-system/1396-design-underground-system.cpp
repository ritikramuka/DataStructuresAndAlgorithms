class UndergroundSystem {
    public: 
    map<int, pair<string, int>> m;
    map<string, map<string, pair<int, int>>> v;
    
    UndergroundSystem() { }
    
    void checkIn(int id, string stationName, int t) {
        m[id].first = stationName;
        m[id].second = t;
    }
    
    void checkOut(int id, string stationName, int t) {
        int timetkn = t - m[id].second;
        v[m[id].first][stationName].first++;
        v[m[id].first][stationName].second += timetkn;
    }
    
    double getAverageTime(string startStation, string endStation) {
        int nooftrips = v[startStation][endStation].first;
        int tottime = v[startStation][endStation].second;
        return (double)tottime / (double)nooftrips;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */