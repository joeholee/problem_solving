#include <bits/stdc++.h>
using namespace std;
int N,ret,pos,A[1001],dp[1001],pre[1001];
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) cin >> A[i];
    fill(pre,pre+N,-1);
    fill(dp,dp+1001,1);
    for(int i=0; i<N; i++) {
        for(int j=0; j<i; j++) {
            if(A[i]>A[j]&&dp[i]<dp[j]+1) {
                dp[i]=dp[j]+1;
                pre[i]=j;
            }
        }
        if(ret<dp[i]) {
            ret=dp[i];
            pos=i;
        }
    }
    while(pos!=-1) {
        v.push_back(A[pos]);
        pos=pre[pos];
    }
    cout << ret << '\n';
    for(int i=v.size()-1; i>=0; i--) cout << v[i] << ' ';
    return 0;
}