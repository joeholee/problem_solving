#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, t;
    vector<int> v;
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> t;
        v.push_back(t);
    }
    sort(v.begin(), v.end());
    cout << v[0] << ' ' << v[N-1];
}