#include <bits/stdc++.h>
using namespace std;
int N,ret=1e9;
char a[21][21];
string s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int r=0; r<N; r++) {
        cin >> s;
        for(int c=0; c<N; c++) a[r][c]=s[c];
    }
    for(int mask=0; mask<(1<<N); mask++) {
        int sum=0;
        for(int c=0; c<N; c++) {
            int cnt=0;
            for(int r=0; r<N; r++) {
                char cur = a[r][c];
                if(mask&(1<<r)) cur = (cur=='T' ? 'H' : 'T');
                if(cur=='T') cnt++;
            }
            sum+=min(cnt,N-cnt);
        }
        ret=min(ret,sum);
    }
    cout << ret << '\n';
    return 0;
}