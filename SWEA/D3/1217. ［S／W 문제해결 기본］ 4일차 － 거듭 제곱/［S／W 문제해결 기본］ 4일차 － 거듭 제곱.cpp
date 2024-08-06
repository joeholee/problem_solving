#include <iostream>
using namespace std;

int pow(int N, int M) {
	if(M==1) return N;
    return N*pow(N,M-1);
}

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
	int test_case;
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int T;
        cin >> T;
        int N,M;
        cin >> N >> M;
        cout << "#" << T << " " << pow(N,M) << '\n';
	}
	return 0;
}