#include <bits/stdc++.h>
using namespace std;
stack<char> stc;
stack<int> sti;
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    for(test_case = 1; test_case <= 10; ++test_case)
    {
        int len;
        cin >> len;
        string infix;
        cin >> infix;
        string postfix="";
        // infix -> postfix
        for(int i=0; i<infix.size(); i++) {
            if('0'<=infix[i] && infix[i]<='9') postfix+=infix[i];
            else {
                while(!stc.empty()) {
                    postfix+=stc.top();
                    stc.pop();
                }
                stc.push(infix[i]);
            }
        }
        while(!stc.empty()) {
            postfix+=stc.top();
            stc.pop();
        }
        //eval postfix
        for(int i=0; i<postfix.size(); i++) {
            if('0'<=postfix[i] && postfix[i]<='9') sti.push(postfix[i]-'0');
            else {
                int num1 = sti.top();
                sti.pop();
                int num2 = sti.top();
                sti.pop();
                sti.push(num1+num2);
            }
        }
        cout << "#" << test_case << " " << sti.top() << '\n';
        sti.pop();
    }
    return 0;
}