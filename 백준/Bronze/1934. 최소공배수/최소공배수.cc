#include <bits/stdc++.h>
using namespace std;
int T,A,B;
int gcd(int A, int B) {
    if(A==0) return B;
    return gcd(B%A,A);
}
int lcm(int A, int B) {
    return A*B/gcd(A,B);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> A >> B;
        cout << lcm(A,B) << '\n';
    }
    return 0;
}