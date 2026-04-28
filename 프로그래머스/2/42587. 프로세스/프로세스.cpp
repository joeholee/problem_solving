#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int,int>> q;
    for(int i=0; i<priorities.size(); i++) q.push({i,priorities[i]});
    while(q.size()) {
        int idx=q.front().first; int pri=q.front().second;
        q.pop();
        bool highest=true;
        for(int i=0; i<priorities.size(); i++) {
            if(priorities[i]>pri) {
                highest=false;
                break;
            }
        }
        if(!highest) q.push({idx,pri});
        else {
            answer++;
            priorities[idx]=0;
            if(idx==location) return answer;
        }
    }
    return answer;
}