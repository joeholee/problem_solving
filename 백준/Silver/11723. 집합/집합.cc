#include <bits/stdc++.h>
using namespace std;
int M,x,mask;
string S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> S;
        if(S=="add") {
            cin >> x;
            mask|=(1<<x);
        }
        else if(S=="remove") {
            cin >> x;
            mask&=~(1<<x);
        }
        else if(S=="check") {
            cin >> x;
            cout << (mask&(1<<x) ? 1 : 0) << '\n';
        }
        else if(S=="toggle") {
            cin >> x;
            mask^=(1<<x);
        }
        else if(S=="all") {
            mask=(1<<21)-1;
        }
        else {
            mask=0;
        }
    }
    return 0;
}