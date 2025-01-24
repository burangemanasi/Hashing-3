//187. Repeated DNA Sequences - https://leetcode.com/problems/repeated-dna-sequences/description/

//Brute Force
//Time Complexity: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //add all string to 'allSeq'
        HashSet<String> allSeq = new HashSet<>();
        //add to result only if string repeated
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        //consider 10 characters at a time
        for(int i=0; i<n-9; i++){
            String seq = s.substring(i, i+10); //substring takes 1 extra character
            if(allSeq.contains(seq)){
                result.add(seq);
            } else {
                //occured first time
                allSeq.add(seq);
            }
        }
        return new ArrayList<>(result);
    }
}

//using HashMap of DNA Sequence
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();

        //available characters in DNA
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        long hash = 0l;
        //4: 4 characters, 10: window length
        long posFac = (long)Math.pow(4,10);

        for(int i=0; i<n; i++){
            char in = s.charAt(i);
            //4: avaialble range of characters
            hash = (hash * 4) + map.get(in);

            if(i >= 10){
                //outgoing character is the 1st character of the substring
                //charAt(0)
                char out = s.charAt(i-10);
                hash = hash - (posFac * map.get(out));
            }

            if(allSeq.contains(hash)){ //repeated DNA
                result.add(s.substring(i-9, i+1));
            } else {
                allSeq.add(hash);
            }
        }
        return new ArrayList<>(result);
    }
}

//without using HashMap of DNA Sequence
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();

        // HashMap<Character, Integer> map = new HashMap<>();
        // map.put('A', 1);
        // map.put('C', 2);
        // map.put('G', 3);
        // map.put('T', 4);

        long hash = 0l;
        long posFac = (long)Math.pow(20,10);

        for(int i=0; i<n; i++){
            char in = s.charAt(i);
            hash = (hash * 20) + (in - 'A' +1);

            if(i >= 10){
                char out = s.charAt(i-10);
                hash = hash - (posFac * (out - 'A' +1));
            }

            if(allSeq.contains(hash)){
                result.add(s.substring(i-9, i+1));
            } else {
                allSeq.add(hash);
            }
        }
        return new ArrayList<>(result);
    }
}