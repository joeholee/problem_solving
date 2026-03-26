#include <bits/stdc++.h>
using namespace std;
int N,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=1; i<=N; i++) {
        int tmp=i;
        int sum=i;
        while(tmp) {
            sum+=tmp%10;
            tmp/=10;
        }
        if(sum==N) {
            ret=i;
            break;
        } 
    }
    cout << ret;
    return 0;
}