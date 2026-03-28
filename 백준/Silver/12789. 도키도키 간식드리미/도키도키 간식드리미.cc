#include <bits/stdc++.h>
using namespace std;
int N,x,cur=1;
stack<int> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        if(x==cur) cur++;
        else st.push(x);
        while(st.size()&&st.top()==cur) {
            cur++;
            st.pop();
        }
    }
    cout << (st.empty() ? "Nice" : "Sad") << '\n';
    return 0;
}