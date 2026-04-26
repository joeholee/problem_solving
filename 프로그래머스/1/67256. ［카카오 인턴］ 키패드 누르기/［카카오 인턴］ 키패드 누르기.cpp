#include <bits/stdc++.h>
using namespace std;

int calc(pair<int,int> beg, pair<int,int> en) {
    return abs(beg.first-en.first)+abs(beg.second-en.second);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    pair<int,int> curL={0,3}, curR={2,3};
    for(int i=0; i<numbers.size(); i++) {
        int num=numbers[i];
        if(num==1||num==4||num==7) {
            answer+="L";
            curL={0,num/3};
        } else if(num==3||num==6||num==9) {
            answer+="R";
            curR={2,(num-1)/3};
        } else {
            int pos=((num+1)/3)-1;
            if(pos==-1) pos=3;
            int distL=calc(curL,{1,pos});
            int distR=calc(curR,{1,pos});
            if(distL<distR) {
                answer+="L";
                curL={1,pos};
            } else if(distR<distL) {
                answer+="R";
                curR={1,pos};
            } else {
                if(hand=="left") {
                    answer+="L";
                    curL={1,pos};
                } else {
                    answer+="R";
                    curR={1,pos};
                }
            }
        }
    }
    return answer;
}