#include <bits/stdc++.h>
using namespace std;
int N,M,x,cnt[20000001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        cnt[x+10000000]++;
    }
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> x;
        cout << cnt[x+10000000] << ' ';
    }
    return 0;
}