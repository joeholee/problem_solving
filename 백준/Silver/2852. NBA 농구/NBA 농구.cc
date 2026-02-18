#include <bits/stdc++.h>
using namespace std;
int N,T,ant,bnt,A,B;
string S,pre;
void print(int sum) {
    string ret;
    string min="00"+to_string(sum/60);
    string sec="00"+to_string(sum%60);
    ret+=min.substr(min.size()-2,2)+":"+sec.substr(sec.size()-2,2);
    cout << ret << '\n';
}
void solve(int& sum, string S) {
    int cur = atoi(S.substr(0,2).c_str())*60+atoi(S.substr(3,2).c_str());
    int tmp = atoi(pre.substr(0,2).c_str())*60+atoi(pre.substr(3,2).c_str());
    sum+=cur-tmp;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> T >> S;
        if(ant>bnt) solve(A,S);
        else if(bnt>ant) solve(B,S);
        T==1 ? ant++ : bnt++;
        pre=S;
    }
    if(ant>bnt) solve(A,"48:00");
    else if(bnt>ant) solve(B,"48:00");
    print(A);
    print(B);
    return 0;
}