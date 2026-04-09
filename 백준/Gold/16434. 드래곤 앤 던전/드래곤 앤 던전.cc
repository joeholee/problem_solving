#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll N,atk,ret,t,a,h,cur,dam,mx;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> atk;
    for(int i=0; i<N; i++) {
        cin >> t >> a >> h;
        if(t==1) {
            dam=a*(ceil((double)h/atk)-1);
            if(cur<dam) {
                mx+=dam-cur;
                cur=0;
            } else cur-=dam;
        } else {
            atk+=a;
            cur=min(mx,cur+h);
        }
    }
    cout << mx+1;
    return 0;
}