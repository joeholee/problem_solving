#include <bits/stdc++.h>
using namespace std;
int N,ret,prime[4000001];
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    fill(prime,prime+4000001,1);
    prime[1]=0;
    for(int i=2; i<=sqrt(4000000); i++) {
        if(prime[i]) {
            for(int j=i*i; j<=4000000; j+=i) prime[j]=0;
        }
    }
    for(int i=2; i<=N; i++) {
        if(prime[i]) v.push_back(i);
    }
    int st=0,en=0,sum=0;
    while(true) {
        if(sum>=N) {
            if(sum==N) ret++;
            sum-=v[st++];
        } else {
            if(en==v.size()) break;
            sum+=v[en++];
        }
    }
    cout << ret;
    return 0;
}