class Location {
private:
    string name;
    int score;

public:
    Location (string& name, int score) {
        this->name = name;
        this->score = score;
    }
    
    string getName () {
        return this->name;
    }
    
    int getScore () {
        return this->score;
    }
};

class MaxHeapComp {
public:
    bool operator() (Location*& a, Location*& b) {
        if (a->getScore() == b->getScore()) {
            return a->getName() > b->getName();
        }  
        return a->getScore() < b->getScore();
    };
};

class MinHeapComp {
public:
    bool operator() (Location*& a, Location*& b) {
        if (a->getScore() == b->getScore()) {
            return a->getName() < b->getName();
        }  
        return a->getScore() > b->getScore();
    };
};


class SORTracker {
private:
    priority_queue<Location*, vector<Location*>, MaxHeapComp> maxHeap;
    priority_queue<Location*, vector<Location*>, MinHeapComp> minHeap;
    int getCalls = 0;
    
public:
    SORTracker() {
        
    }
    
    void add(string name, int score) {
        minHeap.push(new Location(name, score));
        if (minHeap.size() > getCalls) {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }
    
    string get() {
        getCalls++;
        Location* ans = maxHeap.top();
        minHeap.push(maxHeap.top());
        maxHeap.pop();
        return ans->getName();
    }
};

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker* obj = new SORTracker();
 * obj->add(name,score);
 * string param_2 = obj->get();
 */