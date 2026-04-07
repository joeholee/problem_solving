#include <bits/stdc++.h>
using namespace std;
int N,S[21][21],ret=987654321;
int calc(int mask) {
    int tmp1=0,tmp2=0;
    for(int i=0; i<N; i++) {
        for(int j=i+1; j<N; j++) {
            if(mask&(1<<i)&&mask&(1<<j)) tmp1+=S[i][j]+S[j][i];
            else if(!(mask&(1<<i))&&!(mask&(1<<j))) tmp2+=S[i][j]+S[j][i];
        }
    }
    return abs(tmp1-tmp2);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) cin >> S[r][c];
    }
    for(int i=0; i<(1<<N); i++) {
        int cnt=0;
        for(int j=0; j<N; j++) {
            if(i&(1<<j)) cnt++;
        }
        if(cnt==N/2) {
            ret=min(ret,calc(i));
        }
    }
    cout << ret;
    return 0;
}