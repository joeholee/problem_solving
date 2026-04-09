#include <bits/stdc++.h>
using namespace std;
int N,num,ret,lis[1001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> num;
        auto pos = lower_bound(lis,lis+ret,num);
        if(*pos==0) ret++;
        *pos=num;
    }
    cout << ret;
    return 0;
}