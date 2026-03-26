#include <bits/stdc++.h>
using namespace std;
int a1,a0,c,n0,flag;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a1 >> a0 >> c >> n0;
    if(a1<=c&&a1*n0+a0<=c*n0) cout << 1;
    else cout << 0;
    return 0;
}