#include <bits/stdc++.h>
using namespace std;
int N,M,sum,mx,A[100001],ret=987654321;
bool check(int mid) {
    if(mx>mid) return false;
    int tmp=mid;
    int cnt=0;
    for(int i=0; i<N; i++) {
        if(mid<A[i]) {
            cnt++;
            mid=tmp;
        }
        mid-=A[i];
    }
    if(mid!=tmp) cnt++;
    return cnt<=M;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) {
        cin >> A[i];
        sum+=A[i];
    }
    mx=*max_element(A,A+N);
    int left=0, right=sum;
    while(left<=right) {
        int mid=(left+right)/2;
        if(check(mid)) {
            ret=min(ret,mid);
            right=mid-1;
        } else left=mid+1;
    }
    cout << ret;
    return 0;
}