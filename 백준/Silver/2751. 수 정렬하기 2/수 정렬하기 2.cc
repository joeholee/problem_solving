#include <bits/stdc++.h>
using namespace std;
int N,x;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        v.push_back(x);
    }
    sort(v.begin(),v.end());
    for(int i : v) cout << i << '\n';
    return 0;
}