#include <bits/stdc++.h>
using namespace std;
int N,s,e,cur,ret;
vector<pair<int,int>> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> s >> e;
        v.push_back({e,s});
    }
    sort(v.begin(),v.end());
    for(int i=0; i<N; i++) {
        if(cur<=v[i].second) {
            cur=v[i].first;
            ret++;
        }
    }
    cout << ret;
    return 0;
}