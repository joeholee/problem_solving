#include <bits/stdc++.h>
using namespace std;
int N,d,p,ret;
vector<pair<int,int>> v;
priority_queue<int,vector<int>,greater<int>> pq;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> d >> p;
        v.push_back({d,p});
    }
    sort(v.begin(),v.end());
    for(int i=0; i<N; i++) {
        pq.push(v[i].second);
        if(pq.size()>v[i].first) pq.pop();
    }
    while(pq.size()) {
        ret+=pq.top();
        pq.pop();
    }
    cout << ret;
    return 0;
}