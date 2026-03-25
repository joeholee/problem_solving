#include <bits/stdc++.h>
using namespace std;
int r1,c1,r2,c2,r3,c3;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> r1 >> c1 >> r2 >> c2 >> r3 >> c3;
    if(r1==r2) cout << r3;
    else if(r1==r3) cout << r2;
    else cout << r1;
    if(c1==c2) cout << " " << c3;
    else if(c1==c3) cout << " " << c2;
    else cout << " " << c1;
    return 0;
}