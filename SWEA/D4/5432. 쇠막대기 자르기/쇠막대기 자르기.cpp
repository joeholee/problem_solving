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
        string input;
        cin >> input;
        stack<char> st;
        int ans=0;
        for(int i=0; i<input.length(); i++) {
            if(input[i]=='(') st.push(input[i]);
            else {
                if(input[i-1]=='(') {
                    st.pop();
                    ans+=st.size();
                }
                else {
                    st.pop();
                    ans++;
                }
            }
        }
        cout << "#" << test_case << " " << ans << '\n';
    }
    return 0;
}