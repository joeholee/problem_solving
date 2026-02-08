#include <bits/stdc++.h>
using namespace std;
string S;
string ROT13(string& S) {
    string ret;
    for(char c : S) {
        if(isupper(c)) ret+=65+(c+13-'A')%26;
        else if(islower(c)) ret+=97+(c+13-'a')%26;
        else ret+=c;
    }
    return ret;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    getline(cin,S);
    cout << ROT13(S) << '\n';
    return 0;
}