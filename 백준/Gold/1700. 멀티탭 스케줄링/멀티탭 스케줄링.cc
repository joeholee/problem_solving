#include <bits/stdc++.h>
using namespace std;
int N,K,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    vector<int> v(K);
    for(int i=0; i<K; i++) cin >> v[i];
    vector<int> vv;
    for(int i=0; i<K; i++) {
        int cur=v[i];
        bool use=false;
        for(int x : vv) {
            if(x==cur) {
                use=1;
                break;
            }
        }
        if(use) continue;
        if(vv.size()<N) {
            vv.push_back(cur);
            continue;
        }
        int target=-1;
        int far=-1;
        for(int j=0; j<vv.size(); j++) {
            int dev=vv[j];
            int nxt=-1;
            for(int k=i+1; k<K; k++) {
                if(v[k]==dev) {
                    nxt=k;
                    break;
                }
            }
            if(nxt==-1) {
                target=j;
                break;
            }
            if(nxt>far) {
                far=nxt;
                target=j;
            }
        }
        vv[target]=cur;
        ret++;
    }
    cout << ret;
    return 0;
}