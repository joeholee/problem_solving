#include <bits/stdc++.h>
using namespace std;

int N,ans;
bool col[21],diag1[21],diag2[21];

void solve(int cnt) {
    if(cnt==N) {
    	ans++;
        return;
    }
    for(int i=0; i<N; i++) {
    	if(col[i]||diag1[cnt+i]||diag2[cnt-i+N-1]) continue;
        col[i]=1;
        diag1[cnt+i]=1;
        diag2[cnt-i+N-1]=1;
        solve(cnt+1);
        col[i]=0;
        diag1[cnt+i]=0;
        diag2[cnt-i+N-1]=0;
    }
}
int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> N;
        solve(0);
        cout << "#" << test_case << " " << ans << '\n';
        ans=0;
	}
	return 0;
}