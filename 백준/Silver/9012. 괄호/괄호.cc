#include <bits/stdc++.h>
using namespace std;
int T;
string S;
bool solve(string S) {
    stack<char> st;
    for(char c : S) {
        if(!st.empty()) {
            auto cur = st.top();
            if(cur=='('&&c==')') st.pop();
            else st.push(c);
        } else st.push(c);
    }
    if(st.empty()) return true;
    return false;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> S;
        cout << ((solve(S)) ? "YES\n" : "NO\n");
    }
    return 0;
}