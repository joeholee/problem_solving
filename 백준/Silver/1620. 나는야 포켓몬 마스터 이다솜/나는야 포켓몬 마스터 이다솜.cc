#include <bits/stdc++.h>
using namespace std;
int N,M;
map<int,string> m1;
map<string,int> m2;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=1; i<=N; i++) {
        string s;
        cin >> s;
        m1.insert({i,s});
        m2.insert({s,i});
    }
    for(int i=0; i<M; i++) {
        string query;
        cin >> query;
        if(atoi(query.c_str())) cout << m1[stoi(query)] << '\n';
        else cout << m2[query] << '\n';
    }
    return 0;
}