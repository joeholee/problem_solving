#include <bits/stdc++.h>
using namespace std;
int A,B,V,ret;
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> A >> B >> V;
    ret=ceil((double)(V-B)/(A-B));
    cout << ret;
    return 0;
}