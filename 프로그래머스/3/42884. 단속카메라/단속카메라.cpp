#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    sort(routes.begin(), routes.end(), [] (auto l, auto r) {
        return l[1]<r[1];
    });
    int cam=-30001;
    for(int i=0; i<routes.size(); i++) {
        int in=routes[i][0];
        int out=routes[i][1];
        if(cam<in) {
            cam=out;
            answer++;
        }
    }
    return answer;
}