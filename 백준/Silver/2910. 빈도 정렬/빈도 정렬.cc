#include <bits/stdc++.h>
using namespace std;
int N,C;
map<int,int> m,m2;
bool cmp(const pair<int,int> &a, const pair<int,int> &b) {
    if(a.second==b.second) return m2[a.first]<m2[b.first];
    return a.second>b.second;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> C;
    for(int i=0; i<N; i++) {
        int tmp;
        cin >> tmp;
        m[tmp]++;
        if(!m2[tmp]) m2[tmp]=i+1;
    }
    vector<pair<int,int>> v(m.begin(),m.end());
    sort(v.begin(),v.end(),cmp);
    for(auto it : v) {
        for(int i=0; i<it.second; i++) cout << it.first << ' ';
    }
    return 0;
}