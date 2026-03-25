#include <bits/stdc++.h>
using namespace std;
int N;
long long ret;
stack<pair<int,int>> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    while(N--) {
        int h;
        cin >> h;
        int cnt=1;
        while(!st.empty()&&h>=st.top().first) {
            ret+=st.top().second;
            if(h==st.top().first) cnt+=st.top().second;
            st.pop();
        }
        if(!st.empty()) ret++;
        st.push({h,cnt});
    }
    cout << ret << '\n';
    return 0;
}