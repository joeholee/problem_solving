#include <bits/stdc++.h>
using namespace std;
int N,ret,A[21][21];
void move(int dir) {
    switch(dir) {
        case 0: {
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(!A[r][c]) {
                        for(int j=c+1; j<N; j++) {
                            if(A[r][j]) {
                                swap(A[r][c],A[r][j]);
                                break;
                            }
                        }
                    }
                }
                for(int c=0; c<N-1; c++) {
                    if(A[r][c]&&A[r][c]==A[r][c+1]) {
                        A[r][c]*=2;
                        A[r][c+1]=0;
                    }
                }
                for(int c=0; c<N; c++) {
                    if(!A[r][c]) {
                        for(int j=c+1; j<N; j++) {
                            if(A[r][j]) {
                                swap(A[r][c],A[r][j]);
                                break;
                            }
                        }
                    }
                }
            }
            break;
        }
        case 1: {
            for(int r=0; r<N; r++) {
                for(int c=N-1; c>=0; c--) {
                    if(!A[r][c]) {
                        for(int j=c-1; j>=0; j--) {
                            if(A[r][j]) {
                                swap(A[r][c],A[r][j]);
                                break;
                            }
                        }
                    }
                }
                for(int c=N-1; c>0; c--) {
                    if(A[r][c]&&A[r][c]==A[r][c-1]) {
                        A[r][c]*=2;
                        A[r][c-1] = 0;
                    }
                }
                for(int c= N-1; c>=0; c--) {
                    if(!A[r][c]) {
                        for(int j=c-1; j>=0; j--) {
                            if(A[r][j]) {
                                swap(A[r][c],A[r][j]);
                                break;
                            }
                        }
                    }
                }
            }
            break;
        }
        case 2: {
            for(int c=0; c<N; c++) {
                for(int r=0; r<N; r++) {
                    if(!A[r][c]) {
                        for(int j=r+1; j<N; j++) {
                            if (A[j][c]) {
                                swap(A[r][c],A[j][c]);
                                break;
                            }
                        }
                    }
                }
                for(int r=0; r<N-1; r++) {
                    if(A[r][c]&& A[r][c]==A[r+1][c]) {
                        A[r][c]*=2;
                        A[r+1][c] = 0;
                    }
                }
                for(int r=0; r<N; r++) {
                    if(!A[r][c]) {
                        for(int j=r+1; j<N; j++) {
                            if(A[j][c]) {
                                swap(A[r][c],A[j][c]);
                                break;
                            }
                        }
                    }
                }
            }
            break;
        }
        case 3: {
            for(int c=0; c<N; c++) {
                for(int r=N-1; r>=0; r--) {
                    if(!A[r][c]) {
                        for(int j=r-1; j>=0; j--) {
                            if(A[j][c]) {
                                swap(A[r][c],A[j][c]);
                                break;
                            }
                        }
                    }
                }
                for(int r=N-1; r>0; r--) {
                    if(A[r][c]&&A[r][c]==A[r-1][c]) {
                        A[r][c]*=2;
                        A[r-1][c]=0;
                    }
                }
                for(int r=N-1; r>=0; r--) {
                    if(!A[r][c]) {
                        for(int j=r-1; j>=0; j--) {
                            if(A[j][c]) {
                                swap(A[r][c],A[j][c]);
                                break;
                            }
                        }
                    }
                }
            }
            break;
        }
    }
}
void dfs(int cnt) {
    if(cnt==5) {
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                ret=max(ret,A[r][c]);
            }
        }
        return;
    }
    int tmp[21][21]={0,};
    memcpy(tmp,A,sizeof(A));
    for(int dir=0; dir<4; dir++) {
        move(dir);
        dfs(cnt+1);
        memcpy(A,tmp,sizeof(tmp));
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) cin >> A[r][c];
    }
    dfs(0);
    cout << ret;
    return 0;
}