#include <bits/stdc++.h>
using namespace std;
int N,a[21],ret=1e9;
string s;
void solve(int idx) {
    if(idx==N) {
        int tmp=0;
        for(int i=1; i<=(1<<(N-1)); i*=2) {
            int cnt=0;
            for(int j=0; j<N; j++) if(a[j]&i) cnt++;
            tmp+=min(cnt,N-cnt);
        }
        ret=min(ret,tmp);
        return;
    }
    solve(idx+1);
    a[idx]=~a[idx];
    solve(idx+1);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> s;
        int val=1;
        for(int j=0; j<N; j++) {
            if(s[j]=='T') a[i]|=val;
            val*=2;
        }
    }
    solve(0);
    cout << ret << '\n';
    return 0;
}