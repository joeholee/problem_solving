#include <bits/stdc++.h>
using namespace std;
int N;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=2; i<=sqrt(N); i++) {
        while(!(N%i)) {
            cout << i << '\n';
            N/=i;
        }
    }
    if(N>1) cout << N;
    return 0;
}