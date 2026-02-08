#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int T,n;
ll ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> n;
        map<string,int> m;
        for(int i=0; i<n; i++) {
            string name,type;
            cin >> name >> type;
            m[type]++;
        }
        ret=1;
        for(auto it : m) ret*=(ll)(it.second+1);
        ret--;
        cout << ret << '\n';
    }
    return 0;
}