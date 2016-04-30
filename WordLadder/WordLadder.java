import java.util.*;

public class WordLadder{

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 0;
        if(beginWord.length()==0 || beginWord==null){return length;}
        Queue<String> q = new LinkedList<String>();
        HashSet<String> explored = new HashSet<String>();
        q.offer(beginWord);
        explored.add(beginWord);
        length = 1;
        wordList.add(endWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                String s = q.poll();
                if(s.equals(endWord)){return length;}
                char[] schars = s.toCharArray();
                for(int i=0; i<schars.length; i++){
                    char oldChar = schars[i];
                    for(int j=0;j<26;j++){
                        char newChar = (char)('a' + j);
                        if(newChar == oldChar){continue;}
                        schars[i] = newChar;
                        String newS = String.valueOf(schars);
                        if(!explored.contains(newS) && wordList.contains(newS)){
                            q.offer(newS);
                            explored.add(newS);
                        }
                    }
                    schars[i] = oldChar;
                }
            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("lot");
        
        //so a shortest path is "hit" -> "hot" -> "dot" -> "dog" -> "cog" w/len 5
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}