#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, v, arr[201] = {};
    cin >> N;
    while(N--) {
        int t;
        cin >> t;
        arr[t+100]++;
    }
    cin >> v;
    cout << arr[v+100];
}