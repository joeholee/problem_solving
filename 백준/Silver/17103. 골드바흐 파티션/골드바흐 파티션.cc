#include <bits/stdc++.h>
using namespace std;
int T,N,prime[1000001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    fill(prime,prime+1000001,1);
    prime[1]=0;
    for(int i=2; i<=1000; i++) {
        if(prime[i]) {
            for(int j=i*i; j<=1000000; j+=i) prime[j]=0;
        }
    }
    for(int t=0; t<T; t++) {
        cin >> N;
        int ret=0;
        for(int i=2; i<=N/2; i++) {
            if(prime[i]&&prime[N-i]) ret++;
        }
        cout << ret << '\n';
    }
    return 0;
}