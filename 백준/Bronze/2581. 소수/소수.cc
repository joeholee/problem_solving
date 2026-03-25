#include <bits/stdc++.h>
using namespace std;
int M,N,ret,prime[10001],mn=10000;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> M >> N;
    fill(prime,prime+10001,1);
    prime[0]=0;
    prime[1]=0;
    for(int i=2; i*i<=10000; i++) {
        if(prime[i]) {
            for(int j=i*i; j<=10000; j+=i) prime[j]=0;
        }
    }
    for(int i=M; i<=N; i++) {
        if(prime[i]) {
            ret+=i;
            mn=min(mn,i);
        }
    }
    if(!ret) cout << -1;
    else cout << ret << '\n' << mn;
    return 0;
}