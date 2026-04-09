#include <bits/stdc++.h>
using namespace std;
int a,b,num;
set<int> s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a >> b;
    for(int i=0; i<a; i++) {
        cin >> num;
        s.insert(num);
    }
    for(int i=0; i<b; i++) {
        cin >> num;
        if(s.count(num)) s.erase(num);
        else s.insert(num);
    }
    cout << s.size();
    return 0;
}