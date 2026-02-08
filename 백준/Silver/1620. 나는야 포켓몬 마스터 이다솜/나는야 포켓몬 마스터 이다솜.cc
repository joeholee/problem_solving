#include <bits/stdc++.h>
using namespace std;
int N,M;
string tmp;
map<string,int> m1;
map<int,string> m2;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=1; i<=N; i++) {
        cin >> tmp;
        m1.insert({tmp,i});
        m2.insert({i,tmp});
    }
    for(int i=1; i<=M; i++) {
        cin >> tmp;
        if(atoi(tmp.c_str())) cout << m2[atoi(tmp.c_str())] << '\n';
        else cout << m1[tmp] << '\n';
    }
}