#include <bits/stdc++.h>
using namespace std;
int a,b,c,d,e,f,x,y,flag;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a >> b >> c >> d >> e >> f;
    for(int i=-999; i<=999; i++) {
        if(flag) break;
        for(int j=-999; j<=999; j++) {
            if(flag) break;
            if((a*i+b*j)==c&&(d*i+e*j)==f) {
                x=i; y=j;
                flag=1;
            }
        }
    }
    cout << x << ' ' << y;
    return 0;
}