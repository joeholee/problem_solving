#include <bits/stdc++.h>
using namespace std;
int tar,ret;
vector<int> v;
void dfs(int idx, int sum) {
    if(idx==v.size()) {
        if(sum==tar) ret++;
        return;
    }
    dfs(idx+1,sum+v[idx]);
    dfs(idx+1,sum-v[idx]);
}

int solution(vector<int> numbers, int target) {
    v=numbers;
    tar=target;
    dfs(0,0);
    return ret;
}