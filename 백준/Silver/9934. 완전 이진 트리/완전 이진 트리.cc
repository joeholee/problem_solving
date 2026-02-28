#include <bits/stdc++.h>
using namespace std;
int K,a[1024];
vector<vector<int>> v;
void solve(int st, int en, int depth) {
    if(depth==K) return;
    int mid = (st+en)/2;
    v[depth].push_back(a[mid]);
    solve(st,mid,depth+1);
    solve(mid+1,en,depth+1);
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> K;
    int len=pow(2,K)-1;
    for(int i=0; i<len; i++) cin >> a[i];
    for(int i=0; i<10; i++) v.push_back(vector<int>());
    solve(0,len,0);
    for(int i=0; i<K; i++) {
        for(auto vec : v[i]) cout << vec << ' ';
        cout << '\n';
    }
    return 0;
}