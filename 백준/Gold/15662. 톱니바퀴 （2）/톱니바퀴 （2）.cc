#include <bits/stdc++.h>
using namespace std;
int T,K,ret;
bool check[1001];
vector<vector<int>> v;
void rotate(int idx, int dir) {
    check[idx]=1;
    if(idx>1) {
        if(!check[idx-1]&&v[idx][6]!=v[idx-1][2]) rotate(idx-1,-dir);
    }
    if(idx+1<=T) {
        if(!check[idx+1]&&v[idx][2]!=v[idx+1][6]) rotate(idx+1,-dir);
    }
    if(dir==1) rotate(v[idx].rbegin(),v[idx].rbegin()+1,v[idx].rend());
    else rotate(v[idx].begin(),v[idx].begin()+1,v[idx].end());
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int i=0; i<=T; i++) v.push_back({});
    for(int i=1; i<=T; i++) {
        string s;
        cin >> s;
        for(char c : s) v[i].push_back(c-'0');
    }
    cin >> K;
    for(int i=0; i<K; i++) {
        int idx,dir;
        cin >> idx >> dir;
        fill(check,check+1001,0);
        rotate(idx,dir);
    }
    for(int i=1; i<=T; i++) {
        if(v[i][0]) ret++;
    }
    cout << ret;
    return 0;
}