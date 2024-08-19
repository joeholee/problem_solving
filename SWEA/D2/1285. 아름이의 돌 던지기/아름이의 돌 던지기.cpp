#include <bits/stdc++.h>
using namespace std;
int N,arr[1001],near,cnt;

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> N;
        for(int i=1; i<=N; i++) {
            cin >> arr[i];
            arr[i] = abs(arr[i]);
        }
        sort(arr+1,arr+N+1);
        near=arr[1];
        cnt=1;
        for(int i=2; i<=N; i++) {
            if(arr[i]==near) cnt++;
            else break;
        }
        cout << "#" << test_case << " " << near << " " << cnt << "\n";
	}
	return 0;
}