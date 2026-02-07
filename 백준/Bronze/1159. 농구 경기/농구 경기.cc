#include <bits/stdc++.h>
using namespace std;
int N,nam[26];
string tmp,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> tmp;
        nam[tmp[0]-'a']++;
    }
    for(int i=0; i<26; i++) {
        if(nam[i]>=5) ret+=i+'a';
    }
    ret = (ret.empty()) ? "PREDAJA" : ret;
    cout << ret << '\n';
    return 0;
}