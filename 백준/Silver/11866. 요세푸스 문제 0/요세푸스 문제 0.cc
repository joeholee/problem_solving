#include <bits/stdc++.h>
using namespace std;
int N,K,cnt;
queue<int> q;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i=1; i<=N; i++) q.push(i);
    while(q.size()) {
        int x=q.front();
        q.pop();
        cnt++;
        if(cnt==K) {
            v.push_back(x);
            cnt=0;
        } else q.push(x);
    }
    cout << '<';
    for(int i=0; i<N; i++) {
        if(i==N-1) cout << v[i];
        else cout << v[i] << ", ";
    }
    cout << '>';
    return 0;
}