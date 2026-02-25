#include <bits/stdc++.h>
using namespace std;
int N,ret=-987654321;
string S;
vector<int> num;
vector<char> op;
int calc(char c, int a, int b) {
    if(c=='+') return a+b;
    else if(c=='-') return a-b;
    else return a*b;
}
void solve(int idx, int cur) {
    if(idx==num.size()-1) {
        ret=max(ret,cur);
        return;
    }
    solve(idx+1,calc(op[idx],cur,num[idx+1]));
    if(idx+2<=num.size()-1) {
        int tmp=calc(op[idx+1],num[idx+1],num[idx+2]);
        solve(idx+2,calc(op[idx],cur,tmp));
    }
    return;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> S;
    for(int i=0; i<N; i++) {
        if(i%2==0) num.push_back(S[i]-'0');
        else op.push_back(S[i]);
    }
    solve(0,num[0]);
    cout << ret << '\n';
    return 0;
}