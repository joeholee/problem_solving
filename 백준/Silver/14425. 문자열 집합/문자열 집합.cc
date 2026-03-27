#include <bits/stdc++.h>
using namespace std;
int N,M,ret;
string s;
set<string> S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) {
        cin >> s;
        S.insert(s);
    }
    for(int i=0; i<M; i++) {
        cin >> s;
        if(S.find(s)!=S.end()) ret++;
    }
    cout << ret;
    return 0;
}