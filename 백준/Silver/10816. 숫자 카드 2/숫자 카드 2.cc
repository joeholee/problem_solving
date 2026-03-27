#include <bits/stdc++.h>
using namespace std;
int N,M,x;
unordered_map<int,int> m;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        m[x]++;
    }
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> x;
        cout << m[x] << ' ';
    }
    return 0;
}