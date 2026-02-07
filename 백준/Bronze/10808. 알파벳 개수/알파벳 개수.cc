#include <bits/stdc++.h>
using namespace std;
int cnt[26];
string S;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> S;
    for(char c : S) cnt[c-'a']++;
    for(int i : cnt) cout << i << " ";
    return 0;
}