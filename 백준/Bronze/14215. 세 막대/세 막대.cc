#include <bits/stdc++.h>
using namespace std;
int a,b,c,mx;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a >> b >> c;
    mx=max(a,max(b,c));
    if(mx==a) {
        if(a<b+c) cout << a+b+c;
        else cout << 2*(b+c)-1;
    }
    else if(mx==b) {
        if(b<c+a) cout << a+b+c;
        else cout << 2*(c+a)-1;
    }
    else {
        if(c<a+b) cout << a+b+c;
        else cout << 2*(a+b)-1;
    }
    return 0;
}