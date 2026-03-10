#include <bits/stdc++.h>
using namespace std;
int N,L,ret,a[101][101],b[101][101];
void solve(int arr[101][101]) {
    for(int r=0; r<N; r++) {
        int cnt=1;
        int c;
        for(c=0; c<N-1; c++) {
            if(arr[r][c]==arr[r][c+1]) cnt++;
            else if(arr[r][c]+1==arr[r][c+1]&&cnt>=L) cnt=1;
            else if(arr[r][c]-1==arr[r][c+1]&&cnt>=0) cnt=-L+1;
            else break;
        }
        if(c==N-1&&cnt>=0) ret++;
    }
    return;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> L;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            cin >> a[r][c];
            b[c][r]=a[r][c];
        }
    }
    solve(a); solve(b);
    cout << ret << '\n';
    return 0;
}