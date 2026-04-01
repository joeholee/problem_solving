#include <bits/stdc++.h>
using namespace std;
#define ll long long
int N;
bool check[100001];
ll ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    vector<int> v(N);
    for(int i=0; i<N; i++) cin >> v[i];
    int st=0,en=0;
    while(st<N) {
        if(en<N&&!check[v[en]]) {
            check[v[en++]]=1;
        }
        else {
            ret+=en-st;
            check[v[st++]]=0;
        }
    }
    cout << ret;
    return 0;
}