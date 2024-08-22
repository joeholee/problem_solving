#include <bits/stdc++.h>
using namespace std;
int tmp,ans,n,w[10001];

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=1; i<=2*n; i++) cin >> w[i];
    sort(w+1,w+2*n+1);
    ans = w[1]+w[2*n];
    for(int i=1; i<=n; i++) {
        tmp=w[i]+w[2*n+1-i];
        if(ans>tmp) ans=tmp;
    }
    cout << ans;
}