#include <bits/stdc++.h>
using namespace std;
int A,B,C;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> A >> B >> C;
    int tmp=0;
    tmp+=A*60+B+C;
    if(tmp>=24*60) tmp-=24*60;
    A=tmp/60;
    B=tmp%60;
    cout << A << ' ' << B;
    return 0;
}