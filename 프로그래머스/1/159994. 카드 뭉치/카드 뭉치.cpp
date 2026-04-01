#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";
    int idx1=0, idx2=0, flag=0;
    for(int i=0; i<goal.size(); i++) {
        for(int j=0; j<cards1.size(); j++) {
            if(cards1[j]==goal[i]) {
                if(idx1>j||j-idx1>1) {
                    flag=1;
                    break;
                }
                idx1=j;
            }
        }
        if(flag) break;
        for(int j=0; j<cards2.size(); j++) {
            if(cards2[j]==goal[i]) {
                if(idx2>j||j-idx2>1) {
                    flag=1;
                    break;
                }
                idx2=j;
            }
        }
        if(flag) break;
    }
    answer = flag ? "No" : "Yes";
    return answer;
}