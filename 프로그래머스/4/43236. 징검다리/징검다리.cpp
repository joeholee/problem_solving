#include <bits/stdc++.h>
using namespace std;

bool check(int mid, int distance, vector<int> &rocks, int n) {
    int rem=0;
    int prev=0;
    for(int i=0; i<rocks.size(); i++) {
        if(rocks[i]-prev<mid) rem++;
        else prev=rocks[i];
    }
    if(distance-prev<mid) rem++;
    return rem<=n;
}

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(),rocks.end());
    int st=0, en=distance;
    while(st<=en) {
        int mid=(st+en)/2;
        if(check(mid,distance,rocks,n)) {
            answer=mid;
            st=mid+1;
        } else en=mid-1;
    }
    return answer;
}