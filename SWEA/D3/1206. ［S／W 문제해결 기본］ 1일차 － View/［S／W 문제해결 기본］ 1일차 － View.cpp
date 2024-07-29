#include<bits/stdc++.h>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int N;
        cin >> N;
        int arr[N];
        for(int i=0; i<N; i++) cin >> arr[i];
        int ans = 0;
        for(int i=2; i<N-2; i++) {
            int tmp=0;
            for(int j=i-2; j<i; j++) {
                if(arr[j]>=arr[i]) goto out;
                if(arr[j]>=tmp) tmp=arr[j];
            }
            for(int j=i+1; j<i+3; j++) {
                if(arr[j]>=arr[i]) goto out;
                if(arr[j]>=tmp) tmp=arr[j];
            }
            ans += arr[i]-tmp;
            out: continue;
        }
        cout << "#" << test_case << " " << ans << '\n';
	}
	return 0;
}