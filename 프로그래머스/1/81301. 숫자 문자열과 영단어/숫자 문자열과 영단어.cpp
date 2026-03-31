#include <bits/stdc++.h>

using namespace std;

unordered_map<int,string> m = {
    {0,"zero"}, {1,"one"}, {2,"two"}, {3,"three"}, {4,"four"}, {5,"five"},
    {6,"six"}, {7,"seven"}, {8,"eight"}, {9,"nine"}
};

int solution(string s) {
    int answer = 0;
    for(int i=0; i<10; i++) {
        auto it=0;
        while((it=s.find(m[i]))!=-1) {
            s.replace(it,m[i].length(),to_string(i));
        }
    }
    answer=stoi(s);
    return answer;
}