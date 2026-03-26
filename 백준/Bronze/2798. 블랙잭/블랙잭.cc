#include <bits/stdc++.h>
using namespace std;
int N,M,sum,ret;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    for(int i=0; i<N-2; i++) {
        for(int j=i+1; j<N-1; j++) {
            for(int k=j+1; k<N; k++) {
                sum=v[i]+v[j]+v[k];
                if(sum<=M) ret=max(ret,sum);
            }
        }
    }
    cout << ret;
    return 0;
}