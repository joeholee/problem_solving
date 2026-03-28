#include <bits/stdc++.h>
using namespace std;
int N,op,val;
deque<int> dq;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> op;
        switch(op)
        {
            case 1:
                cin >> val;
                dq.push_front(val);
                break;
            case 2:
                cin >> val;
                dq.push_back(val);
                break;
            case 3:
                if(dq.size()) {
                    int x=dq.front();
                    dq.pop_front();
                    cout << x << '\n';
                } else cout << -1 << '\n';
                break;
            case 4:
                if(dq.size()) {
                    int x=dq.back();
                    dq.pop_back();
                    cout << x << '\n';
                } else cout << -1 << '\n';
                break;
            case 5:
                cout << dq.size() << '\n';
                break;
            case 6:
                cout << (dq.empty() ? 1 : 0) << '\n';
                break;
            case 7:
                cout << (dq.size() ? dq.front() : -1) << '\n';
                break;
            case 8:
                cout << (dq.size() ? dq.back() : -1) << '\n';
                break;
        }
    }
    return 0;
}