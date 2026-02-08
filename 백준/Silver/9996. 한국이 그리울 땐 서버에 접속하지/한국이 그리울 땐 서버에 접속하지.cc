#include <bits/stdc++.h>
using namespace std;
int N;
string S,Q,pre,suf;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> S;
    int pos = S.find('*');
    pre = S.substr(0,pos);
    suf = S.substr(pos+1);
    for(int i=0; i<N; i++) {
        cin >> Q;
        if(pre.length()+suf.length()>Q.length()) cout << "NE" << '\n';
        else {
            if(Q.substr(0,pre.length())==pre && Q.substr(Q.length()-suf.length())==suf) cout << "DA" << '\n';
            else cout << "NE" << '\n';
        }
    }
    return 0;
}