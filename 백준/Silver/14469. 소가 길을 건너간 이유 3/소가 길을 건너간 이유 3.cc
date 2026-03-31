#include <bits/stdc++.h>
using namespace std;
int N,a,t,ret;
vector<pair<int,int>> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> a >> t;
        v.push_back({a,t});
    }
    sort(v.begin(),v.end());
    ret=v[0].first+v[0].second;
    for(int i=1; i<N; i++) {
        ret=max(ret,v[i].first);
        ret+=v[i].second;
    }
    cout << ret;
    return 0;
}