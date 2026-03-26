#include <bits/stdc++.h>
using namespace std;
int N,x;
map<int,int> m;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        if(m[x]==0) m[x]=1;
        else m[x]++; 
    }
    for(auto it : m) {
        for(int i=0; i<it.second; i++) cout << it.first << '\n';
    }
    return 0;
}