#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
    int N;
    cin >> N;
    int arr[N];
    for(int i=0; i<N; i++) cin >> arr[i];
    for(int i=N-1; i>0; i--) {
        for(int j=0; j<i; j++) {
            if(arr[j]>arr[j+1]) {
                int tmp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=tmp;
            }
        }
    }
    cout << arr[N/2];
	return 0;
}