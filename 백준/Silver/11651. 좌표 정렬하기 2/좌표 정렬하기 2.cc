#include <bits/stdc++.h>
using namespace std;
int N,x,y;
vector<pair<int,int>> v;
bool cmp(pair<int,int> a, pair<int,int> b) {
    if(a.second==b.second) return a.first<b.first;
    return a.second<b.second;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x >> y;
        v.push_back({x,y});
    }
    sort(v.begin(),v.end(),cmp);
    for(auto it : v) cout << it.first << ' ' << it.second << '\n';
    return 0;
}