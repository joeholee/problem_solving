#include <bits/stdc++.h>
using namespace std;
int n,prime[250000];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    fill(prime,prime+250000,1);
    prime[1]=0;
    for(int i=2; i<=sqrt(250000); i++) {
        if(prime[i]) {
            for(int j=i*i; j<=250000; j+=i) prime[j]=0;
        }
    }
    while(cin >> n) {
        if(n==0) break;
        int ret=0;
        for(int i=n+1; i<=2*n; i++) {
            if(prime[i]) ret++;
        }
        cout << ret << '\n';
    }
    return 0;
}