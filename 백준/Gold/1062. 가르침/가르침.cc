#include <bits/stdc++.h>
using namespace std;
int N,K,ret;
vector<int> words;
void dfs(int idx, int cnt, int mask) {
    if(cnt==K) {
        int tmp=0;
        for(int i : words) {
            if((i&mask)==i) tmp++;
        }
        ret=max(ret,tmp);
        return;
    }
    for(int i=idx; i<26; i++) {
        if(mask&(1<<i)) continue;
        dfs(i+1,cnt+1,mask|(1<<i));
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    if(K<5) { cout << 0; return 0;}
    if(K==26) { cout << N; return 0; }
    int mask=0;
    mask |= (1<<('a'-'a'));
    mask |= (1<<('c'-'a'));
    mask |= (1<<('i'-'a'));
    mask |= (1<<('n'-'a'));
    mask |= (1<<('t'-'a'));
    for(int i=0; i<N; i++) {
        string S; cin >> S;
        int bit=0;
        for(char c : S) bit |= (1<<(c-'a'));
        words.push_back(bit);
    }
    dfs(0,5,mask);
    cout << ret << '\n';
    return 0;
}