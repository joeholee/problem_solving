#include <bits/stdc++.h>
using namespace std;
string N;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    sort(N.rbegin(),N.rend());
    cout << N;
    return 0;
}