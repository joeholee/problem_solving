#include <bits/stdc++.h>
using namespace std;
int N,ret;
vector<int> v;
int gcd(int a, int b) {
    if(a==0) return b;
    return gcd(b%a,a);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    int d=v[1]-v[0];
    for(int i=1; i<N-1; i++) {
        d=gcd(d,v[i+1]-v[i]);
    }
    for(int i=0; i<N-1; i++) {
        ret+=(v[i+1]-v[i])/d-1;
    }
    cout << ret;
    return 0;
}