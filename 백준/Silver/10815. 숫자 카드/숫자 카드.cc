#include <bits/stdc++.h>
using namespace std;
int N,M,x;
set<int> s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        s.insert(x);
    }
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> x;
        cout << (s.find(x)!=s.end() ? 1 : 0) << ' ';
    }
    return 0;
}