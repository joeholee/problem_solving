#include <bits/stdc++.h>
using namespace std;
int N,x,cur=1;
stack<int> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        if(x==cur) {
            cur++;
            while(st.size()&&st.top()==cur) {
                cur++;
                st.pop();
            }
        }
        else if(st.size()&&st.top()==cur) {
            while(st.top()==cur) {
                cur++;
                st.pop();
            }
        }
        else st.push(x);
    }
    cout << (st.empty() ? "Nice" : "Sad") << '\n';
    return 0;
}