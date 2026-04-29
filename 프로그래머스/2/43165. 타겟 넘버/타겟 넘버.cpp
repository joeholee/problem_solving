#include <bits/stdc++.h>
using namespace std;

int dfs(int cnt, int sum, vector<int> &numbers, int target) {
    if(cnt==numbers.size()) {
        if(sum==target) return 1;
        return 0;
    }
    return dfs(cnt+1,sum+numbers[cnt],numbers,target)+dfs(cnt+1,sum-numbers[cnt],numbers,target);
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    answer=dfs(0,0,numbers,target);
    return answer;
}