#include <bits/stdc++.h>
using namespace std;
int N,M,ret;
vector<int> a;
void comb(int idx, vector<int> &v) {
    if(v.size()==2) {
        int tmp=0;
        for(int i : v) tmp+=i;
        if(tmp==M) ret++;
        return;
    }
    for(int i=idx; i<a.size(); i++) {
        v.push_back(a[i]);
        comb(i+1,v);
        v.pop_back();
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> M;
    for(int i=0; i<N; i++) {
        int x;
        cin >> x;
        a.push_back(x);
    }
    sort(a.begin(),a.end());
    vector<int> tmp;
    comb(0,tmp);
    cout << ret << '\n';
    return 0;
}