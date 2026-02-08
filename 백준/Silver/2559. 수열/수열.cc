#include <bits/stdc++.h>
using namespace std;
int N,K,arr[100004],psum[100004];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i=1; i<=N; i++) {
        cin >> arr[i];
        psum[i]+=psum[i-1]+arr[i];
    }
    int ret = INT_MIN;
    for(int i=0; i<N-K+1; i++) ret = max(ret,psum[K+i]-psum[i]);
    cout << ret << '\n';
    return 0;
}