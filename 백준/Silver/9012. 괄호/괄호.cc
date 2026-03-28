#include <bits/stdc++.h>
using namespace std;
int T;
string s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> s;
        stack<char> st;
        for(char c : s) {
            if(c=='(') st.push(c);
            else {
                if(st.size()&&st.top()=='(') st.pop();
                else st.push(c);
            }
        }
        cout << (st.empty() ? "YES" : "NO") << '\n';
    }
    return 0;
}