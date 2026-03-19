#include <bits/stdc++.h>
using namespace std;
int T,n;
vector<int> v;
string p,tmp;
void func(vector<int> &v, string query) {
    int st=0;
    int en=v.size()-1;
    bool rev=false;
    for(char c : query) {
        if(c=='R') rev=!rev;
        else {
            if(st>en) {
                cout << "error\n";
                return;
            }
            if(!rev) st++;
            else en--;
        }
    }
    cout << "[";
    if(st<=en) {
        if(rev) {
            for(int i=en; i>=st; i--) {
                cout << v[i];
                if(i!=st) cout << ',';
            }
        }
        else {
            for(int i=st; i<=en; i++) {
                cout << v[i];
                if(i!=en) cout << ',';
            }
        }
    }
    cout << "]\n";
}
vector<int> split(string s, string delim) {
    vector<int> ret;
    if(s.empty()) return ret;
    auto st=0;
    auto en=s.find(delim);
    while(en!=-1) {
        ret.push_back(atoi(s.substr(st,en-st).c_str()));
        st=en+delim.size();
        en=s.find(delim,st);
    }
    ret.push_back(atoi(s.substr(st).c_str()));
    return ret;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        cin >> p;
        cin >> n;
        cin >> tmp;
        v=split(tmp.substr(1,tmp.size()-2),",");
        func(v,p);
    }
    return 0;
}