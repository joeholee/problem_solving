#include <bits/stdc++.h>
using namespace std;
int N,x,y,mx=100000,my=100000,Mx=-10000,My=-10000;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    if(N==1) { cout << 0; return 0; }
    for(int i=0; i<N; i++) {
        cin >> x >> y;
        mx=min(mx,x); my=min(my,y);
        Mx=max(Mx,x); My=max(My,y);
    }
    cout << (Mx-mx)*(My-my);
    return 0;
}