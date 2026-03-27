#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll a1,b1,a2,b2;
ll gcd(ll a, ll b) {
    if(a==0) return b;
    return gcd(b%a,a);
}
ll lcm(ll a, ll b) {
    return a*b/gcd(a,b);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a1 >> b1 >> a2 >> b2;
    ll cd=lcm(b1,b2);
    ll val=a1*cd/b1+a2*cd/b2;
    ll c1=val/gcd(cd,val);
    ll c2=cd/gcd(cd,val);
    cout << c1 << ' ' << c2;
    return 0;
}