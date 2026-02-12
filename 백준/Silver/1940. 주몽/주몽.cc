#include <bits/stdc++.h>
using namespace std;
int N,M,ret;
vector<int> a;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> M;
    for(int i=0; i<N; i++) {
        int x;
        cin >> x;
        a.push_back(x);
    }
    sort(a.begin(),a.end());
    int l=0,r=N-1;
    while(l<r) {
        int sum=a[l]+a[r];
        if(sum==M) {
            ret++;
            l++;
            r--;
        }
        else if(sum>M) r--;
        else l++;
    }
    cout << ret << '\n';
}