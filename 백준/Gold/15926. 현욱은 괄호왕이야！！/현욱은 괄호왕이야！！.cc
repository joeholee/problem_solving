#include <bits/stdc++.h>
using namespace std;
int n,arr[200001],cnt,ret;
string s;
stack<int> st;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    cin >> s;
    for(int i=0; i<n; i++) {
        if(s[i]=='(') st.push(i);
        else if(!st.empty()) {
            arr[i]=arr[st.top()]=1;
            st.pop();
        }
    }
    for(int i=0; i<n; i++) {
        if(arr[i]) {
            cnt++;
            ret=max(ret,cnt);
        }
        else cnt=0;
    }
    cout << ret << '\n';
    return 0;
}