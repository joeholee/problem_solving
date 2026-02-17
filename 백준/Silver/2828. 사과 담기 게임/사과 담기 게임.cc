#include <bits/stdc++.h>
using namespace std;
int N,M,J,tmp,ret,en,st=1;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> J;
    for(int i=0; i<J; i++) {
        en=st+M-1;
        cin >> tmp;
        if(st<=tmp&&tmp<=en) continue;
        if(st>tmp) {
            ret+=(st-tmp);
            st=tmp;
        } else {
            ret+=(tmp-en);
            st+=(tmp-en);
        }
    }
    cout << ret << '\n';
    return 0;
}