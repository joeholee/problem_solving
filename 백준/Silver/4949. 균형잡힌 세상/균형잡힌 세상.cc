#include <bits/stdc++.h>
using namespace std;
string S;
bool check(const string& S) {
    stack<char> st;
    for(char c : S) {
        if(c=='('||c=='[') st.push(c);
        else if(c==')') {
            if(st.empty()||st.top()!='(') return false;
            st.pop();
        }
        else if(c==']') {
            if(st.empty()||st.top()!='[') return false;
            st.pop();
        }
        else continue;
    }
    return st.empty();
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    while(getline(cin,S)) {
        if(S==".") break;
        cout << (check(S) ? "yes\n" : "no\n");
    }
    return 0;
}