#include <bits/stdc++.h>
using namespace std;
int a,b,x,ret;
unordered_map<int,int> m;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a >> b;
    for(int i=0; i<a; i++) {
        cin >> x;
        m[x]++;
    }
    for(int i=0; i<b; i++) {
        cin >> x;
        m[x]++;
    }
    for(auto it : m) {
        if(it.second==1) ret++;
    }
    cout << ret;
    return 0;
}