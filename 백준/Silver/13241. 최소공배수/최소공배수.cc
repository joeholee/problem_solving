#include <bits/stdc++.h>
using namespace std;
#define lli long long int
lli A,B;
lli gcd(lli A, lli B) {
    if(A==0) return B;
    return gcd(B%A,A);
}
lli lcm(lli A, lli B) {
    return A*B/gcd(A,B);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> A >> B;
    cout << lcm(A,B);
    return 0;
}