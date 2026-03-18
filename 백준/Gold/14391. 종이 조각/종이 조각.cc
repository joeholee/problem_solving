#include <bits/stdc++.h>
using namespace std;
int N,M,a[4][4],ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<N; r++) {
        string S;
        cin >> S;
        for(int c=0; c<M; c++) a[r][c]=S[c]-'0';
    }
    for(int i=0; i<(1<<(N*M)); i++) {
        int sum=0;
        for(int r=0; r<N; r++) {
            int cur=0;
            for(int c=0; c<M; c++) {
                int idx=r*M+c;
                if(i&(1<<idx)) {
                    sum+=cur;
                    cur=0;
                }
                else cur=cur*10+a[r][c];
            }
            sum+=cur;
        }
        for(int c=0; c<M; c++) {
            int cur=0;
            for(int r=0; r<N; r++) {
                int idx=r*M+c;
                if(i&(1<<idx)) cur=cur*10+a[r][c];
                else {
                    sum+=cur;
                    cur=0;
                }
            }
            sum+=cur;
        }
        ret=max(ret,sum);
    }
    cout << ret << '\n';
    return 0;
}