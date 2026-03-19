#include <bits/stdc++.h>
using namespace std;
string A,B,ret;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> A >> B;
    if(A.size()>B.size()) {
        string tmp="";
        for(int i=0; i<A.size()-B.size(); i++) tmp+="0";
        B=tmp+B;
    }
    else if(B.size()>A.size()) {
        string tmp="";
        for(int i=0; i<B.size()-A.size(); i++) tmp+="0";
        A=tmp+A;
    }
    int carry=0;
    for(int i=A.size()-1; i>=0; i--) {
        int a=A[i]-'0';
        int b=B[i]-'0';
        int sum=a+b+carry;
        carry=sum/10;
        char c=(sum%10)+'0';
        ret=c+ret;
    }
    if(carry) ret='1'+ret;
    cout << ret << '\n';
    return 0;
}