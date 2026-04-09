#include <bits/stdc++.h>
using namespace std;
int N,M,A[300001],ret=987654321;
long long tot;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<M; i++) cin >> A[i];
    int left=1;
    int right=*max_element(A,A+M);
    while(left<=right) {
        int mid=(left+right)/2;
        long long sum=0;
        for(int i=0; i<M; i++) {
            sum+=A[i]/mid;
            if(A[i]%mid) sum++;
        }
        if(sum<=N) {
            ret=min(ret,mid);
            right=mid-1;
        } else left=mid+1;
    }
    cout << ret;
    return 0;
}