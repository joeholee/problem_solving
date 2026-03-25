#include <bits/stdc++.h>
using namespace std;
int H,M;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> H >> M;
    int tmp=0;
    tmp+=(H*60)+M;
    if((tmp-45)<0) tmp+=24*60;
    H=(tmp-45)/60;
    M=(tmp-45)%60;
    cout << H << ' ' << M;
    return 0;
}