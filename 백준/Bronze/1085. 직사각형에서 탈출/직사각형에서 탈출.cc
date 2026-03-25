#include <bits/stdc++.h>
using namespace std;
int x,y,w,h;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> x >> y >> w >> h;
    cout << min(min(x,w-x),min(y,h-y));
    return 0;
}