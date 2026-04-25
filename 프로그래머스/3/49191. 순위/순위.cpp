#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<int>> v(n+1,vector<int>(n+1,0));
    for(auto r : results) {
        int a=r[0];
        int b=r[1];
        v[a][b]=1;
    }
    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(v[i][k]&&v[k][j]) v[i][j]=1;
            }
        }
    }
    for(int i=1; i<=n; i++) {
        int cnt=0;
        for(int j=1; j<=n; j++) {
            if(v[i][j]||v[j][i]) cnt++;
        }
        if(cnt==n-1) answer++;
    }
    return answer;
}