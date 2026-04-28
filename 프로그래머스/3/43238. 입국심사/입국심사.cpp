#include <bits/stdc++.h>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = LLONG_MAX;
    sort(times.begin(),times.end());
    long long st=0, en=1LL*n*times[times.size()-1];
    while(st<=en) {
        long long mid=(st+en)/2;
        long long sum=0;
        for(int i : times) sum+=mid/i;
        if(sum>=n) {
            en=mid-1;
            answer=min(answer,mid);
        } else st=mid+1;
    }
    return answer;
}