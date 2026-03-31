#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll N,K,M,V,c,ret;
vector<pair<ll,ll>> v;
vector<ll> C;
priority_queue<ll> pq;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i=0; i<N; i++) {
        cin >> M >> V;
        v.push_back({M,V});
    }
    for(int i=0; i<K; i++) {
        cin >> c;
        C.push_back(c);
    }
    sort(v.begin(),v.end());
    sort(C.begin(),C.end());
    ll idx=0;
    for(int i=0; i<K; i++) {
        ll tmp=C[i];
        while(idx<N&&tmp>=v[idx].first) {
            pq.push(v[idx].second);
            idx++;
        }
        if(pq.size()) {
            ret+=pq.top();
            pq.pop();
        }
    }
    cout << ret;
    return 0;
}