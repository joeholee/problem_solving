#include <bits/stdc++.h>
using namespace std;
int N,ret,A[1001],dp[1001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) cin >> A[i];
    fill(dp,dp+1001,1);
    for(int i=0; i<N; i++) {
        for(int j=0; j<i; j++) {
            if(A[i]>A[j]) dp[i]=max(dp[i],dp[j]+1);
        }
        ret=max(ret,dp[i]);
    }
    cout << ret;
    return 0;
}