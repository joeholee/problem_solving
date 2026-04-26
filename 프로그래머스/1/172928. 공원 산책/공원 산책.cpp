#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    pair<int,int> cur;
    for(int r=0; r<park.size(); r++) {
        for(int c=0; c<park[0].size(); c++) {
            if(park[r][c]=='S') cur={r,c};
        }
    }
    for(int i=0; i<routes.size(); i++) {
        char op=routes[i][0];
        int dist=routes[i][2]-'0';
        if(op=='N') {
            if(cur.first-dist<0) continue;
            bool flag=1;
            for(int r=cur.first; r>=cur.first-dist; r--) {
                if(park[r][cur.second]=='X') {
                    flag=0;
                    break;
                }
            }
            if(flag) cur.first-=dist;
        } else if(op=='S') {
            if(cur.first+dist>=park.size()) continue;
            bool flag=1;
            for(int r=cur.first; r<=cur.first+dist; r++) {
                if(park[r][cur.second]=='X') {
                    flag=0;
                    break;
                }
            }
            if(flag) cur.first+=dist;
        } else if(op=='W') {
            if(cur.second-dist<0) continue;
            bool flag=1;
            for(int c=cur.second; c>=cur.second-dist; c--) {
                if(park[cur.first][c]=='X') {
                    flag=0;
                    break;
                }
            }
            if(flag) cur.second-=dist;
        } else {
            if(cur.second+dist>=park[0].size()) continue;
            bool flag=1;
            for(int c=cur.second; c<=cur.second+dist; c++) {
                if(park[cur.first][c]=='X') {
                    flag=0;
                    break;
                }
            }
            if(flag) cur.second+=dist;
        }
    }
    answer.push_back(cur.first); answer.push_back(cur.second);
    return answer;
}