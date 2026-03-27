#include <bits/stdc++.h>
using namespace std;
int N,x;
vector<int> X,v;
map<int,int> m;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        X.push_back(x);
        v.push_back(x);
    }
    sort(v.begin(),v.end());
    v.erase(unique(v.begin(),v.end()),v.end());
    for(int i=0; i<v.size(); i++) m.insert({v[i],i});
    for(int i : X) cout << m[i] << ' ';
    return 0;
}