#include <bits/stdc++.h>
using namespace std;
queue<string> q1;
queue<string> q2;
string ans;
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    int T;
    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N;
        cin >> N;
        for(int i=0; i<((N+1)/2); i++) {
            string input;
            cin >> input;
            q1.push(input);
        }
        for(int i=((N+1)/2); i<N; i++) {
            string input;
            cin >> input;
            q2.push(input);
        }
        while(!q1.empty() && !q2.empty()) {
            ans+=q1.front() + " ";
            q1.pop();
            ans+=q2.front() + " ";
            q2.pop();
        }
        if(!q1.empty()) {
            ans+=q1.front();
            q1.pop();
        }
        cout << "#" << test_case << " " << ans << '\n';
        ans="";
    }
    return 0;
}