#include <bits/stdc++.h>
using namespace std;
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    int T;
    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int K;
        cin >> K;
        stack<int> st;
        int ans=0;
        while(K--) {
            int tmp;
            cin >> tmp;
            if(tmp==0) st.pop();
            else st.push(tmp);
        }
        while(!st.empty()) {
            ans+=st.top();
            st.pop();
        }
        cout << "#" << test_case << " " << ans << '\n';
    }
    return 0;
}