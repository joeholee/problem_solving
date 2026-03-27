#include <bits/stdc++.h>
using namespace std;
int N;
string s;
vector<string> v;
bool cmp(string &a, string &b) {
    if(a.length()==b.length()) return a<b;
    return a.length()<b.length();
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> s;
        v.push_back(s);
    }
    sort(v.begin(),v.end(),cmp);
    v.erase(unique(v.begin(),v.end()),v.end());
    for(auto it : v) cout << it << '\n';
    return 0;
}