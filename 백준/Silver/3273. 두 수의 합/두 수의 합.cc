#include <bits/stdc++.h>
using namespace std;
int n,x,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    vector<int> a(n);
    for(int i=0; i<n; i++) cin >> a[i];
    cin >> x;
    sort(a.begin(),a.end());
    int i=0,j=n-1;
    while(i<j) {
        if(a[i]+a[j]>=x) {
            if(a[i]+a[j]==x) ret++;
            j--;
        } else i++;
    }
    cout << ret;
    return 0;
}