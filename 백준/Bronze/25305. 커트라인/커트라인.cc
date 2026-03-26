#include <bits/stdc++.h>
using namespace std;
int N,k,x;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> k;
    for(int i=0; i<N; i++) {
        cin >> x;
        v.push_back(x);
    }
    sort(v.rbegin(),v.rend());
    cout << v[k-1];
    return 0;
}