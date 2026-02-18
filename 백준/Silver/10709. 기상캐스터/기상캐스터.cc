#include <bits/stdc++.h>
using namespace std;
int H,W,ret[101][101];
string m[101];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> H >> W;
    for(int r=0; r<H; r++) {
        cin >> m[r];
    }
    for(auto r : ret) fill(r,r+101,-1);
    for(int r=0; r<H; r++) {
        int idx=-1;
        for(int c=0; c<W; c++) {
            if(m[r][c]=='c') {
                ret[r][c]=0;
                idx=c;
            } else {
                if(idx>-1) ret[r][c]=c-idx;
            }
        }
    }
    for(int r=0; r<H; r++) {
        for(int c=0; c<W; c++) cout << ret[r][c] << ' ';
        cout << '\n';
    }
    return 0;
}