#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    for(int i=0; i<progresses.size(); i++) q.push(ceil((double)(100-progresses[i])/speeds[i]));
    while(q.size()) {
        int cur=q.front();
        int cnt=0;
        while(q.size()&&cur>=q.front()) {
            q.pop();
            cnt++;
        }
        answer.push_back(cnt);
    }
    return answer;
}