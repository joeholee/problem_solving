#include <bits/stdc++.h>
using namespace std;
int n;
bool isPerfect(int n, vector<int> &v) {
    int sum=0;
    for(int i=1; i<=sqrt(n); i++) {
        if(!(n%i)) {
            sum+=i;
            v.push_back(i);
            if(i!=n/i&&n/i!=n) {
                sum+=n/i;
                v.push_back(n/i);
            }
        }
    }
    if(sum==n) return 1;
    else return 0;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    while(true) {
        cin >> n;
        if(n==-1) break;
        vector<int> v;
        if(isPerfect(n,v)) {
            sort(v.begin(), v.end());
            cout << n << " = ";
            for(int i=0; i<v.size()-1; i++) cout << v[i] << " + ";
            cout << v[v.size()-1] << '\n';
        }
        else cout << n << " is NOT perfect.\n";
    }
}