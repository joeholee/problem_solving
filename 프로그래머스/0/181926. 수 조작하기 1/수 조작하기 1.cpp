#include <string>
#include <vector>

using namespace std;

int solution(int n, string control) {
    int ret=n;
    for(char c : control) {
        switch(c) {
            case 'w':
                ret++;
                break;
            case 's':
                ret--;
                break;
            case 'd':
                ret+=10;
                break;
            case 'a':
                ret-=10;
                break;
        }
    }
    return ret;
}