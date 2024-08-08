#include <bits/stdc++.h>
using namespace std;
int N;
long arr[1000001];
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case)
    {
        cin >> N;
        for(int i=1; i<=N; i++) cin >> arr[i];
        long sum=0;
        long curMax=arr[N];
        for(int i=N-1; i>=1; i--) {
            if(curMax<arr[i]) curMax=arr[i];
            else sum+=curMax-arr[i];
        }
        cout << "#" << test_case << " " << sum << '\n';
    }
    return 0;
}