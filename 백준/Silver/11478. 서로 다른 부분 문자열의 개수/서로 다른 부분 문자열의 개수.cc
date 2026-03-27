#include <bits/stdc++.h>
using namespace std;
string S;
unordered_set<string> s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S;
    for(int i=0; i<S.length(); i++) {
        for(int j=1; j<=S.length()-i; j++) {
            s.insert(S.substr(i,j));
        }
    }
    cout << s.size();
    return 0;
}