#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll N,atk,ret,t[123457],a[123457],h[123457];
bool check(ll mid) {
    ll mx=mid;
    ll cur_atk=atk;
    for(int i=0; i<N; i++) {
        if(t[i]==1) {
            ll cnt=h[i]/cur_atk+(h[i]%cur_atk ? 1 : 0);
            mid-=(cnt-1)*a[i];
        } else {
            mid=min(mx,mid+h[i]);
            cur_atk+=a[i];
        }
        if(mid<=0) return false;
    }
    return true;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> atk;
    for(int i=0; i<N; i++) cin >> t[i] >> a[i] >> h[i];
    ll lo=1, hi=1e18;
    while(lo<=hi) {
        ll mid=(lo+hi)/2;
        if(check(mid)) {
            ret=mid;
            hi=mid-1;
        } else lo=mid+1;
    }
    cout << ret;
    return 0;
}