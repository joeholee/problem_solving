#include <bits/stdc++.h>
using namespace std;
int N,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=1; i<=sqrt(N); i++) ret++;
    cout << ret;
    return 0;
}