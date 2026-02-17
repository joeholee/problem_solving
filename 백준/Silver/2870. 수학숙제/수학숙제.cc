#include <bits/stdc++.h>
using namespace std;
int N;
string S;
vector<string> v;
bool cmp(const string& a, const string& b) {
    if(a.size()!=b.size()) return a.size()<b.size();
    return a<b;
}
void solve(string S) {
    string cur;
    for(char c : S) {
        if(isdigit(c)) cur+=c;
        else {
            if(!cur.empty()) {
                while(cur[0]=='0'&&cur.size()>1) cur.erase(cur.begin());
                v.push_back(cur);
                cur.clear();
            }
        }
    }
    if(!cur.empty()) {
        while(cur[0]=='0'&&cur.size()>1) cur.erase(cur.begin());
        v.push_back(cur);
        cur.clear();
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> S;
        solve(S);
    }
    sort(v.begin(),v.end(),cmp);
    for(auto it : v) cout << it << '\n';
    return 0;
}