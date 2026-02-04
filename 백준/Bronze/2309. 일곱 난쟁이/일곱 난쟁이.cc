#include <bits/stdc++.h>
using namespace std;
int arr[9], sum;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for(int i=0; i<9; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    sort(arr, arr+9);
    for(int a=0; a<8; a++) {
        for(int b=1; b<9; b++) {
            if(sum-arr[a]-arr[b] == 100) {
                for(int c=0; c<9; c++) {
                    if(c==a || c==b) continue;
                    cout << arr[c] << '\n';
                }
                return 0;
            }
        }
    }
}