#include <bits/stdc++.h>
using namespace std;
int n,arr[2000001],x,ans;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    while(n--) {
        int tmp;
        cin >> tmp;
        arr[tmp]++;
    }
    cin >> x;
    for(int i=1; i<(x+1)/2; i++) {
        if(arr[i]&&arr[x-i]) ans++;
    }
    cout << ans;
}