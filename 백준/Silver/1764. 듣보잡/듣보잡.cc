#include <bits/stdc++.h>
using namespace std;
int N,M,ret;
string s;
unordered_map<string,int> m;
vector<string> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) {
        cin >> s;
        m[s]++;
    }
    for(int i=0; i<M; i++) {
        cin >> s;
        m[s]++;
    }
    for(auto it : m) {
        if(it.second==2) v.push_back(it.first);
    }
    sort(v.begin(),v.end());
    cout << v.size() << '\n';
    for(string s : v) cout << s << '\n';
    return 0;
}