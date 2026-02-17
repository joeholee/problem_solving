#include <bits/stdc++.h>
using namespace std;
string board[64];
int N;

bool check(int x, int y, int n) {
    for(int i=x; i<x+n; i++) {
        for(int j=y; j<y+n; j++) {
            if(board[x][y] != board[i][j]) return false;
        }
    }
    return true;
}

void func(int x, int y, int z) {
    if(check(x,y,z)) {
        cout << board[x][y];
        return;
    }
    cout << '(';
    int n = z/2;
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) func(x+i*n,y+j*n,n);
    }
    cout << ')';
    return;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) cin >> board[i];
    func(0,0,N);
}