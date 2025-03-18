//
// Created by Bruce on 24-10-12.
//
#include "iostream"
#include "algorithm"
#include "vector"
using namespace std;

struct counter{
public:int left;
public:int right;
};

int findMinRight(vector<counter> counters,int leftIndex,int rightIndex){
    int min = counters[leftIndex].right;
    for (int i = leftIndex; i < rightIndex; ++i) {
        if (counters[i].right < min){
            min = counters[i].right;
        }
    }
    return min;
}

int main(){
    int n;
    cin>>n;
    vector<counter> counters(n);
    for (int i = 0; i < n; ++i) {
        cin>>counters[i].left>>counters[i].right;
    }
    sort(counters.begin(), counters.end(),[](const counter& a,const counter& b){
        return a.left<b.left;
    });
    int ptr=0;
    int leftIndex = 0;
    int time = 0;
    while(leftIndex<n){
        if (counters[leftIndex].left > (ptr+27)){
            ptr+=27;
            time++;
            continue;
        } else{
            int minRight = findMinRight(counters,leftIndex,n);
            if (minRight>(ptr+27)){
                ptr+=27;
            }else{
                ptr = minRight;
            }
            time++;
            while(counters[leftIndex].left<=ptr){
                leftIndex++;
            }
            continue;
        }
    }
    cout<<time<<"T";
    return 0;
} 