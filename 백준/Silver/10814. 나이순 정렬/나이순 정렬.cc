#include <bits/stdc++.h>
using namespace std;
int N,age;
string name;
vector<pair<int,string>> v;
bool cmp(pair<int,string> a, pair<int,string> b) {
    return a.first<b.first;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> age >> name;
        v.push_back({age,name});
    }
    stable_sort(v.begin(),v.end(),cmp);
    for(auto it : v) cout << it.first << ' ' << it.second << '\n';
    return 0;
}