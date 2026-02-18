#include <bits/stdc++.h>
using namespace std;
int T;
string S;
bool solve(string S) {
    stack<char> st;
    for(char c : S) {
        if(c=='(') st.push(c);
        else {
            if(st.empty()) return false;
            st.pop();
        }
    }
    return st.empty();
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