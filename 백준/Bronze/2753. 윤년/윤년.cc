#include <bits/stdc++.h>
using namespace std;
int n,flag;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    if((!(n%4)&&(n%100))||!(n%400)) flag=1;
    cout << (flag ? 1 : 0) << '\n';
    return 0;
}