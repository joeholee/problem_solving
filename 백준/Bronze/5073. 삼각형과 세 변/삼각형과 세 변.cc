#include <bits/stdc++.h>
using namespace std;
int a,b,c;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    while(true) {
        scanf("%d %d %d",&a,&b,&c);
        if(a==0&&b==0&&c==0) break;
        if(a>=b+c||b>=c+a||c>=a+b) printf("Invalid\n");
        else {
            if(a==b&&b==c) printf("Equilateral\n");
            else if(a!=b&&b!=c&&c!=a) printf("Scalene\n");
            else printf("Isosceles\n");
        }
    }
    return 0;
}