#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int arr[] = {10,8,6,5,4,3,2,1};
    vector<pair<string,char> > v;
    for(int i=0; i<8; i++) {
        string record;
        char team;
        cin >> record >> team;
        v.push_back({record,team});
    }
    sort(v.begin(),v.end());
    int red=0, blue=0;
    for(int i=0; i<8; i++) {
        if(v[i].second=='R') red+=arr[i];
        else blue+=arr[i];
    }
    cout << (red > blue ? "Red" : "Blue");
}