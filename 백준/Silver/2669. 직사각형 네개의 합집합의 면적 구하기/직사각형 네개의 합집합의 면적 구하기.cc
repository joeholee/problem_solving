#include <bits/stdc++.h>
using namespace std;
bool vis[102][102];
int x_1,y_1,x_2,y_2;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for(int i=0; i<4; i++) {
        cin >> x_1 >> y_1 >> x_2 >> y_2;
        for(int x=x_1; x<x_2; x++) {
            for(int y=y_1; y<y_2; y++) vis[x][y]=1;
        }
    }
    int ans=0;
    for(int i=1; i<=100; i++) {
        for(int j=1; j<=100; j++) if(vis[i][j]) ans++;
    }
    cout << ans;
}