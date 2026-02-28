#include <bits/stdc++.h>
using namespace std;
int k;
string mx="";
string mn="9999999999";
char a[10];
bool vis[10];
bool comp(char x, char y, char op) {
    if(op=='<') return x<y;
    else return x>y;
}
void solve(int idx, string cur) {
    if(idx==k+1) {
        if(cur>mx) mx=cur;
        if(cur<mn) mn=cur;
        return;
    }
    for(int i=0; i<=9; i++) {
        if(vis[i]) continue;
        if(idx==0||comp(cur[idx-1],i+'0',a[idx-1])) {
            vis[i]=true;
            solve(idx+1,cur+(char)(i+'0'));
            vis[i]=false;
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> k;
    for(int i=0; i<k; i++) cin >> a[i];
    solve(0,"");
    cout << mx << '\n' << mn << '\n';
    return 0;
}