#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    int cnt=1;
    int range=2;
    if(N!=1) {
        while(range<=N) {
            range+=(6*cnt);
            cnt++;
        }
    }
    cout << cnt << '\n';
}