#include <bits/stdc++.h>
using namespace std;
int A,B;

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> A >> B;
        cout << "#" << test_case << " " << (A+B)%24 << "\n";
	}
	return 0;
}