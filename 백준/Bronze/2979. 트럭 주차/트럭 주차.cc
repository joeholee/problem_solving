#include <bits/stdc++.h>
using namespace std;
int A,B,C,in,out,sum,park[101];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> A >> B >> C;
    for(int i=0; i<3; i++) {
        cin >> in >> out;
        for(int i=in; i<out; i++) park[i]++;
    }
    for(int i=1; i<=100; i++) {
        if(park[i]) {
            if(park[i]==1) sum+=A;
            else if(park[i]==2) sum+=2*B;
            else sum+=3*C;
        }
    }
    cout << sum << '\n';
    return 0;
}