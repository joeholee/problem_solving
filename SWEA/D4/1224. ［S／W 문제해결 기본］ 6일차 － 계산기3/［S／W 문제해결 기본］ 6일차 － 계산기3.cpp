#include <bits/stdc++.h>
using namespace std;
stack<char> stc;
stack<int> sti;
map<char,int> m;
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    m['+']=1;
    m['*']=2;
    for(test_case = 1; test_case <= 10; ++test_case)
    {
        int len;
        cin >> len;
        string infix;
        cin >> infix;
        string postfix;
        // infix -> postfix
        for(int i=0; i<infix.size(); i++) {
            if('0'<=infix[i] && infix[i]<='9') postfix+=infix[i];
            else if(infix[i]=='(') stc.push(infix[i]);
            else if(infix[i]==')') {
            	while(stc.top()!='(') {
                	postfix+=stc.top();
                    stc.pop();
                }
                stc.pop();
            }
            else {
                while(!stc.empty() && m.find(stc.top())->second >= m.find(infix[i])->second) {
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
        // eval postfix
        for(int i=0; i<postfix.size(); i++) {
            if('0'<=postfix[i]&&postfix[i]<='9') sti.push(postfix[i]-'0');
            else {
                int n1 = sti.top();
                sti.pop();
                int n2 = sti.top();
                sti.pop();
                if(postfix[i]=='+') sti.push(n1+n2);
                else sti.push(n1*n2);
            }
        }
        cout << "#" << test_case << " " << sti.top() << '\n';
        sti.pop();
    }
    return 0;
}