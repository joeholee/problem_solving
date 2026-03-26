#include <bits/stdc++.h>
using namespace std;
int sum,tri[3];
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    for(int i=0; i<3; i++) cin >> tri[i];
    for(int i : tri) sum+=i;
    if(sum!=180) cout << "Error";
    else {
        if(tri[0]==tri[1]&&tri[1]==tri[2]) cout << "Equilateral";
        else if((tri[0]==tri[1])||(tri[1]==tri[2])||(tri[2]==tri[0])) cout << "Isosceles";
        else cout << "Scalene";
    }
    return 0;
}