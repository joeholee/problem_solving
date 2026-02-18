#include <bits/stdc++.h>
using namespace std;
int T,N,two,five;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> N;
        two=0,five=0;
        for(int i=2; i<=N; i*=2) two+=N/i;
        for(int i=5; i<=N; i*=5) five+=N/i;
        cout << min(two,five) << '\n';
    }
    return 0;
}