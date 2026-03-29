#include <bits/stdc++.h>
using namespace std;
int N,M,x;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    vector<int> A(N),B(N);
    for(int i=0; i<N; i++) cin >> A[i];
    for(int i=0; i<N; i++) cin >> B[i];
    deque<int> dq;
    for(int i=0; i<N; i++) {
        if(A[i]==0) dq.push_front(B[i]);
    }
    cin >> M;
    while(M--) {
        cin >> x;
        dq.push_back(x);
        cout << dq.front() << ' ';
        dq.pop_front();
    }
    return 0;
}