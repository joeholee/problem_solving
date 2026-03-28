#include <bits/stdc++.h>
using namespace std;
#define ll long long
int T;
ll n;
bool isPrime(ll n) {
    if(n<=1) return 0;
    if(n==2) return 1;
    if(!(n%2)) return 0;
    for(ll i=3; i<=sqrt(n); i++) {
        if(!(n%i)) return 0;
    }
    return 1;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> n;
        for(ll i=n; ; i++) {
            if(isPrime(i)) {
                cout << i << '\n';
                break;
            }
        }
    }
    return 0;
}