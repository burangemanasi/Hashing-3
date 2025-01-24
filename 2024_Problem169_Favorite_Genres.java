//Favorite Genres - https://leetcode.com/discuss/interview-question/373006

class Solution{
    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userMap,
                                                           Map<String, List<String>> genreMap){

        HashMap<String, String> songToGenreMap = new HashMap<>();
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songToGenreMap.put(song, genre);
            }
        }

        HashMap<String, String> result = new HashMap<>();
        for(String user: userMap.keySet()){
            HashMap<String, Integer> freqMap = new HashMap<>();
            List<String> favGenre = new ArrayList<>();

            List<String> songs = userMap.get(user);
            int max=0;
            for(String song: songs){
                String genre = songToGenreMap.get(song);
                freqMap.put(genre, freqMap.getOrDefault(genre, 0)+1);
                max = Math.max(max, freqMap.get(genre));
            }

            for(String genre: freqMap.keySet()){
                if(freqMap.get(genre) == max){
                    favoriteGenres.add(genre);
                }
            }
            result.put(user, favoriteGenres);
        }
        return result;
    }
}