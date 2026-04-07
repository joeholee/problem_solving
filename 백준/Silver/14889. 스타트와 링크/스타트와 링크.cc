#include <bits/stdc++.h>
using namespace std;
int N,S[21][21],ret=987654321;
int calc(vector<int> &a, vector<int> &b) {
    int tmp1=0, tmp2=0;
    for(int i=0; i<N/2; i++) {
        for(int j=i+1; j<N/2; j++) {
            tmp1+=S[a[i]][a[j]]+S[a[j]][a[i]];
            tmp2+=S[b[i]][b[j]]+S[b[j]][b[i]];
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
        if(__builtin_popcount(i)!=N/2) continue;
        vector<int> start,link;
        for(int j=0; j<N; j++) {
            if(i&(1<<j)) start.push_back(j);
            else link.push_back(j);
        }
        ret=min(ret,calc(start,link));
    }
    cout << ret;
    return 0;
}