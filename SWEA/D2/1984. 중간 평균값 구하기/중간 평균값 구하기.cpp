#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int arr[10];
        for(int i=0; i<10; i++) cin >> arr[i];
        sort(arr,arr+10);
        double sum=0;
        for(int i=1; i<=8; i++) sum+=arr[i];
        double ans = round(sum/8);
        cout << "#" << test_case << " " << (int)ans << '\n';
	}
	return 0;
}