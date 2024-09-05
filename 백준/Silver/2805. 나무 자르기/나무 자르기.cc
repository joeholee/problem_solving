#include <bits/stdc++.h>
using namespace std;
long long M;
int N,ans,tree[1000001];

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) cin >> tree[i];
    sort(tree,tree+N);
    long long left=0, right=tree[N-1], mid;
    while(left<right) {
        long long sum=0;
        mid = floor((left+right)/2);
        for(int i=0; i<N; i++) {
            if(tree[i]-mid>0) sum+=tree[i]-mid;
        }
        if(sum>=M) {
            ans=mid;
            left=mid+1;
        }
        else right=mid;
    }
    cout << ans;
}