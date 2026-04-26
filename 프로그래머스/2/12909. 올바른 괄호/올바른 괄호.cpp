#include <bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<char> st;
    for(char c : s) {
        if(c=='(') st.push(c);
        else {
            if(st.size()&&st.top()=='(') st.pop();
            else st.push(c);
        }
    }
    answer = st.empty();
    return answer;
}