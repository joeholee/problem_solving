#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int N;
ll l,r,x,y,ret;
vector<pair<int,int>> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x >> y;
        v.push_back({x,y});
    }
    sort(v.begin(),v.end());
    l=v[0].first, r=v[0].second;
    for(int i=1; i<N; i++) {
        if(v[i].first>r) {
            ret+=r-l;
            l=v[i].first;
            r=v[i].second;
        }
        else if(r>=v[i].first&&r<=v[i].second) r=v[i].second;
    }
    ret+=r-l;
    cout << ret;
    return 0;
}