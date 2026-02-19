#include <bits/stdc++.h>
using namespace std;
int N,A[1000001];
vector<int> ret;
stack<int> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> A[i];
    }
    ret = vector<int>(N,-1);
    for(int i=0; i<N; i++) {
        while(!st.empty()&&A[st.top()]<A[i]) {
            ret[st.top()]=A[i];
            st.pop();
        }
        st.push(i);
    }
    for(int i : ret) cout << i << ' ';
    return 0;
}