#include <bits/stdc++.h>
using namespace std;
string S,D,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S >> D;
    int s=D.size();
    for(char c : S) {
        ret+=c;
        if(ret.size()>=s) {
            bool flag=1;
            for(int i=0; i<s; i++) {
                if(ret[ret.size()-s+i]!=D[i]) {
                    flag=0;
                    break;
                }
            }
            if(flag) ret.erase(ret.size()-s,s);
        }
    }
    cout << (ret.size() ? ret : "FRULA");
    return 0;
}