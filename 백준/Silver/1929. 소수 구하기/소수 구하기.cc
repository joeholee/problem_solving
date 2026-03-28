#include <bits/stdc++.h>
using namespace std;
int M,N;
vector<int> v;
bool isPrime(int n) {
    if(n<=1) return 0;
    if(n==2) return 1;
    if(!(n%2)) return 0;
    for(int i=3; i<=sqrt(n); i++) {
        if(!(n%i)) return 0;
    }
    return 1;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> M >> N;
    for(int i=M; i<=N; i++) {
        if(isPrime(i)) v.push_back(i);
    }
    for(int i : v) cout << i << '\n';
    return 0;
}