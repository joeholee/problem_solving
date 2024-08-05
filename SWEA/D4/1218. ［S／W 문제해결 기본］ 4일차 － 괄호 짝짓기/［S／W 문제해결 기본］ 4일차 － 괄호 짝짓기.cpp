#include <bits/stdc++.h>
using namespace std;
 
int main(int argc, char** argv)
{
    for(int test_case = 1; test_case <= 10; ++test_case)
    {
        ios::sync_with_stdio(0);
        cin.tie(0);
        int len;
        cin >> len;
        string input;
        cin >> input;
        if(len%2==1) {
            cout << "#" << test_case << " " << 0 << '\n';
            continue;
        }
        stack<char> st;
        for(char c : input) {
            if(c=='(' || c=='[' || c=='{' || c=='<') st.push(c);
            else if(c==')') {
                if(st.top()=='(') st.pop();
                else st.push(c);
            }
            else if(c==']') {
                if(st.top()=='[') st.pop();
                else st.push(c);
            }
            else if(c=='}') {
                if(st.top()=='{') st.pop();
                else st.push(c);
            }
            else {
                if(st.top()=='<') st.pop();
                else st.push(c);
            }
        }
        cout << "#" << test_case << " ";
        cout << (st.empty() ? 1 : 0) << '\n';
    }
    return 0;
}