#include <bits/stdc++.h>
using namespace std;

int N,ans;
bool col[31],diag1[31],diag2[31];

void solve(int cnt) {
    if(cnt==N) {
        ans++;
        return;
    }
    for(int i=0; i<N; i++) {
        if(col[i]||diag1[i+cnt]||diag2[cnt-i+N-1]) continue;
        col[i]=1;
        diag1[i+cnt]=1;
        diag2[cnt-i+N-1]=1;
        solve(cnt+1);
        col[i]=0;
        diag1[i+cnt]=0;
        diag2[cnt-i+N-1]=0;
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    solve(0);
    cout << ans;
}