#include <bits/stdc++.h>
using namespace std;
string S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S;
    int cur=0;
    while(cur<=S.size()) {
        if(S.substr(cur,2)=="pi"||S.substr(cur,2)=="ka") cur+=2;
        else if(S.substr(cur,3)=="chu") cur+=3;
        else break;
    }
    cout << (cur>=S.size() ? "YES" : "NO") << '\n';
    return 0;
}