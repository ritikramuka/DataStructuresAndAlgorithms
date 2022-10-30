class Workers {
public:
    int wage;
    int quality;
    double ratio;
    
    Workers(int wage, int quality) {
        this->wage = wage;
        this->quality = quality;
        this->ratio = wage / (double) quality;
    }
};

class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        int n = quality.size();
        vector<Workers*> workers;
        for (int i = 0; i < n; i++) {
            workers.push_back(new Workers(wage[i], quality[i]));
        }
        sort (workers.begin(), workers.end(), [](Workers* a, Workers* b) {
           return a->ratio < b->ratio;
        });
        
        priority_queue<int> maxHeap;
        double ans = DBL_MAX;
        int q = 0;
        
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() < k) {
                maxHeap.push(workers[i]->quality);
                q += workers[i]->quality;
            } else if (maxHeap.size() == k) {
                if (maxHeap.top() > workers[i]->quality) {
                    q -= maxHeap.top();
                    maxHeap.pop();

                    maxHeap.push(workers[i]->quality);
                    q += workers[i]->quality;
                }
            }
            
            if (maxHeap.size() == k) {
                double cost = q * workers[i]->ratio;
                if (ans > cost) ans = cost;
            }
        }
        
        return ans;
    }
};