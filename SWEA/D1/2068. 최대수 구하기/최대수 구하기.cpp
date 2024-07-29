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
        cout << "#" << test_case << " " << arr[9] << '\n';
	}
	return 0;
}