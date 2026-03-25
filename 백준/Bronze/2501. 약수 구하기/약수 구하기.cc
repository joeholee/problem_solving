#include <bits/stdc++.h>
using namespace std;
int N,K;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i=1; i*i<=N; i++) {
        if(!(N%i)) {
            v.push_back(i);
            if(i!=N/i) v.push_back(N/i);
        }
    }
    sort(v.begin(), v.end());
    cout << (v.size()<K ? 0 : v[K-1]);
    return 0;
}