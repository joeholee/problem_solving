#include <bits/stdc++.h>
using namespace std;
int N,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(ret=666; ; ret++) {
        if(to_string(ret).find("666")!=-1) N--;
        if(!N) break;
    }
    cout << ret;
    return 0;
}