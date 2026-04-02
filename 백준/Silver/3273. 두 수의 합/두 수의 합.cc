#include <bits/stdc++.h>
using namespace std;
int n,x,ret,arr[2000001];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    while(n--) {
        cin >> x;
        arr[x]++;
    }
    cin >> x;
    for(int i=1; i<(x+1)/2; i++) {
        if(arr[i]&&arr[x-i]) ret++;
    }
    cout << ret;
    return 0;
}