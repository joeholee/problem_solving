#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string,int> m;
    for(string p : participant) m[p]++;
    for(string c : completion) m[c]--;
    for(auto it : m) {
        if(it.second>0) return it.first;
    }
}