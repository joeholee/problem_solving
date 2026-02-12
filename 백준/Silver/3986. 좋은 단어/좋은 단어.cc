#include <bits/stdc++.h>
using namespace std;
int N,ret;
stack<char> s;
void solve(const string &S) {
    for(char c : S) {
        if(s.empty()) s.push(c);
        else {
            if(c==s.top()) s.pop();
            else s.push(c);
        }
    }
    if(s.empty()) ret++;
    while(!s.empty()) s.pop();
    return;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        string S;
        cin >> S;
        solve(S);
    }
    cout << ret << '\n';
    return 0;
}