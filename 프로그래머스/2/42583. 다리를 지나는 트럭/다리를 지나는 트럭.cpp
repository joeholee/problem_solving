#include <bits/stdc++.h>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int idx=0;
    int sum=0;
    queue<int> q;
    for(int i=0; i<bridge_length; i++) q.push(0);
    while(idx<truck_weights.size()) {
        answer++;
        sum-=q.front();
        q.pop();
        if(sum+truck_weights[idx]<=weight) {
            q.push(truck_weights[idx]);
            sum+=truck_weights[idx];
            idx++;
        } else q.push(0);
    }
    answer+=bridge_length;
    return answer;
}