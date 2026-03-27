#include <bits/stdc++.h>
using namespace std;
int n;
string name,el;
set<string,greater<string>> S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> name >> el;
        if(el=="enter") S.insert(name);
        else S.erase(name);
    }
    for(string s : S) cout << s << '\n';
    return 0;
}