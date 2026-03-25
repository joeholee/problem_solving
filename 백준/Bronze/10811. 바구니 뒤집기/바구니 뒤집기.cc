#include <bits/stdc++.h>
using namespace std;
int N,M,i,j;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(i=0; i<N; i++) v.push_back(i+1);
    while(M--) {
        cin >> i >> j;
        reverse(v.begin()+i-1,v.begin()+j);
    }
    for(int i : v) cout << i << ' ';
    return 0;
}