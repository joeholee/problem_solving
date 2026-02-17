#include <bits/stdc++.h>
using namespace std;
string s;
int cnt[26];
const char vow[] = {'a','e','i','o','u'};
bool solve(string s) {
    fill(cnt,cnt+26,0);
    for(char c : s) cnt[c-'a']++;
    int vcnt=0;
    for(char c : vow) {
        if(cnt[c-'a']) vcnt++;
    }
    if(!vcnt) return false;
    if(s.length()>=2) {
        for(int i=0; i<s.length()-1; i++) {
            int j=i+1;
            if(s[i]==s[j]) {
                if(s[i]=='e'||s[i]=='o') continue;
                return false;
            }
        }
    }
    if(s.length()>=3) {
        for(int i=0; i<s.length()-2; i++) {
            int tmp=0;
            for(int d=0; d<3; d++) {
                for(char c : vow) if(s[i+d]==c) tmp++;
            }
            if(!tmp||tmp==3) return false;
        }
    }
    return true;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    while(cin>>s) {
        if(s=="end") exit(0);
        cout << '<' << s << "> is ";
        if(!solve(s)) cout << "not ";
        cout << "acceptable.\n";
    }
}