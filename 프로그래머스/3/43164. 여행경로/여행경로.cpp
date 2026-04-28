#include <bits/stdc++.h>
using namespace std;

vector<int> vis;

vector<string> dfs(string cur, vector<vector<string>> &tickets, vector<string> &route, int cnt) {
    if(cnt==tickets.size()) {
        return route;
    }
    for(int i=0; i<tickets.size(); i++) {
        if(vis[i]) continue;
        if(cur!=tickets[i][0]) continue;
        vis[i]=1;
        route.push_back(tickets[i][1]);
        vector<string> ret=dfs(tickets[i][1],tickets,route,cnt+1);
        if(!ret.empty()) return ret;
        route.pop_back();
        vis[i]=0;
    }
    return {};
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    sort(tickets.begin(), tickets.end(), [] (auto left, auto right) {
        if(left[0]==right[0]) return left[1]<right[1];
        return left[0]<right[0];
    });
    vis.resize(tickets.size());
    fill(vis.begin(),vis.end(),0);
    answer.push_back("ICN");
    answer=dfs("ICN",tickets,answer,0);
    return answer;
}