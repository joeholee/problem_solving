#include <bits/stdc++.h>
using namespace std;
int pal=1;
string S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S;
    for(int i=0; i<S.length()/2; i++) {
        if(S[i]!=S[S.length()-1-i]) {
            pal=0;
            break;
        }
    }
    cout << pal << '\n';
    return 0;
}