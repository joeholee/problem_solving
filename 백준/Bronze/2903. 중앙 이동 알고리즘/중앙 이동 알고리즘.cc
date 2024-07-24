#include <bits/stdc++.h>
using namespace std;
int N;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    int init=2;
    while(N--) init = init*2-1;
    cout << init*init;
}