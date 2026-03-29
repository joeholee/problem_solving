#include <bits/stdc++.h>
using namespace std;
int N;
deque<pair<int,int>> dq;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        int x;
        cin >> x;
        dq.push_back({i+1,x});
    }
    while(dq.size()) {
        int pos=dq.front().first;
        int mv=dq.front().second;
        dq.pop_front();
        cout << pos << ' ';
        if(dq.empty()) break;
        if(mv>0) {
            for(int i=0; i<mv-1; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        } else {
            for(int i=0; i<-mv; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
    return 0;
}