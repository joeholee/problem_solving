#include <bits/stdc++.h>
using namespace std;
int N,mp,mf,ms,mv,a[16][5];
vector<int> getVec(int mask) {
    vector<int> v;
    for(int i=0; i<N; i++) {
        if(mask&(1<<i)) v.push_back(i+1);
    }
    return v;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> mp >> mf >> ms >> mv;
    for(int i=0; i<N; i++) {
        for(int j=0; j<5; j++) cin >> a[i][j];
    }
    int bestC=7500;
    vector<int> bestV;
    for(int mask=1; mask<(1<<N); mask++) {
        int p=0,f=0,s=0,v=0,c=0;
        for(int i=0; i<N; i++) {
            if(mask&(1<<i)) { p+=a[i][0]; f+=a[i][1]; s+=a[i][2]; v+=a[i][3]; c+=a[i][4]; }
        }
        if(p>=mp&&f>=mf&&s>=ms&&v>=mv) {
            vector<int> cur = getVec(mask);
            if(bestV.empty()||c<bestC) {
                bestC=c;
                bestV=cur;
            }
            else if(c==bestC&&cur<bestV) bestV=cur;
        }
    }
    if(bestV.empty()) {
        cout << -1;
        return 0;
    }
    cout << bestC << '\n';
    for(int i : bestV) cout << i << ' ';
    return 0;
}