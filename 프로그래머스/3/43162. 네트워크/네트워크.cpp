#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> v;
vector<int> p;
int findSet(int x) {
    if(p[x]!=x) p[x]=findSet(p[x]);
    return p[x];
}
void uni(int a, int b) {
    p[findSet(b)]=findSet(a);
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<n; i++) p.push_back(i);
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(computers[i][j]&&i!=j) uni(i,j);
        }
    }
    set<int> s;
    for(int i=0; i<n; i++) s.insert(findSet(i));
    answer=s.size();
    return answer;
}