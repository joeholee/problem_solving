#include <bits/stdc++.h>
using namespace std;
int M,N,ret,mn=10000;
bool isPrime(int x) {
    if(x<=1) return 0;
    if(x==2) return 1;
    if(!(x%2)) return 0;
    for(int i=3; i*i<=x; i++) {
        if(!(x%i)) return 0;
    }
    return 1;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> M >> N;
    for(int i=M; i<=N; i++) {
        if(isPrime(i)) {
            ret+=i;
            mn=min(mn,i);
        }
    }
    if(!ret) cout << -1;
    else cout << ret << '\n' << mn;
    return 0;
}