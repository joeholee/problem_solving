#include <bits/stdc++.h>
using namespace std;
int N,x,a[10001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        a[x]++;
    }
    for(int i=1; i<=10000; i++) {
        if(a[i]) {
            for(int j=0; j<a[i]; j++) cout << i << '\n';
        }
    }
    return 0;
}