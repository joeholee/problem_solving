#include <bits/stdc++.h>
using namespace std;
int X,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> X;
    for(int i=0; i<7; i++) {
        if(X&(1<<i)) ret++;
    }
    cout << ret << '\n';
    return 0;
}