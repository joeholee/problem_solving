#include <bits/stdc++.h>
using namespace std;
string S,D,ret;
stack<char> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S >> D;
    for(char c : S) {
        st.push(c);
        if(st.size()>=D.size()) {
            if(st.top()==D[D.size()-1]) {
                string s="";
                for(int i=0; i<D.size(); i++) {
                    s+=st.top();
                    st.pop();
                }
                reverse(s.begin(),s.end());
                if(s!=D) {
                    for(char c : s) {
                        st.push(c);
                    }
                }
            }
        }
    }
    if(st.empty()) cout << "FRULA";
    else {
        while(st.size()) {
            ret+=st.top();
            st.pop();
        }
        reverse(ret.begin(),ret.end());
        cout << ret;
    }
    return 0;
}