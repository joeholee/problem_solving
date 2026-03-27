#include <bits/stdc++.h>
using namespace std;
int N,x,y;
vector<pair<int,int>> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x >> y;
        v.push_back({x,y});
    }
    sort(v.begin(),v.end());
    for(auto it : v) cout << it.first << ' ' << it.second << '\n';
    return 0;
}