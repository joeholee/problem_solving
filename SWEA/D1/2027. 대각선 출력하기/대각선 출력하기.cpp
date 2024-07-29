#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
    for(int i=0; i<5; i++) {
        for(int j=0; j<i; j++) cout << "+";
        cout << "#";
        for(int j=4; j>i; j--) cout << "+";
        cout << '\n';
    }
    return 0;
}