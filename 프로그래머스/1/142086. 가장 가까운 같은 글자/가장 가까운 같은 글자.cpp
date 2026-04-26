#include <bits/stdc++.h>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    unordered_map<char,int> m;
    for(int i=0; i<s.size(); i++) {
        if(m.find(s[i])!=m.end()) answer.push_back(i-m[s[i]]);
        else answer.push_back(-1);
        m[s[i]]=i;
    }
    return answer;
}