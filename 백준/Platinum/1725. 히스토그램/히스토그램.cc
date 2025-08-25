#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    stack<pair<int, int>> S;
    int ans = 0;
    for(int i=0; i<N; i++) {
        int h;
        cin >> h;
        int idx = i;
        while(!S.empty() && S.top().first>=h) {
            ans = max(ans, (i-S.top().second) * S.top().first);
            idx = S.top().second;
            S.pop();
        }
        S.push({h,idx});
    }
    while(!S.empty()) {
        ans = max(ans, (N-S.top().second) * S.top().first);
        S.pop();
    }
    cout << ans << '\n';
}