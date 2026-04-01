#include <bits/stdc++.h>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    for(char c : s) {
        int cnt=index;
        while(cnt) {
            c++;
            if(c>'z') c='a';
            if(skip.find(c)==-1) cnt--;
        }
        answer+=c;
    }
    return answer;
}