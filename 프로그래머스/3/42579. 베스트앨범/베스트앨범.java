import java.util.*;

class Solution {
    static class Song {
        int idx, plays;
        
        Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreMap = new HashMap<>();
        for(int i=0; i<len; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i],0)+plays[i]);
            if(!genreMap.containsKey(genres[i])) genreMap.put(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(new Song(i,plays[i]));
        }
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a,b) -> Integer.compare(genreTotal.get(b),genreTotal.get(a)));
        List<Integer> ans = new ArrayList<>();
        for(String genre : genreOrder) {
            List<Song> l = genreMap.get(genre);
            l.sort((a,b) -> {
                if(a.plays==b.plays) return a.idx-b.idx;
                return b.plays-a.plays;
            });
            for(int i=0; i<l.size() && i<2; i++) ans.add(l.get(i).idx);
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) answer[i]=ans.get(i);
        return answer;
    }
}