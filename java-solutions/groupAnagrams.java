package javaLeetcodeSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class groupAnagramSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> letterMap = new HashMap<>();
        List<List<String>> output = new ArrayList<List<String>>();

        for(String s : strs)
        {
            List<Integer> letterList = new ArrayList<>(Collections.nCopies(26, 0));
            for(char c : s.toCharArray())
            {
                letterList.set(c - 97, letterList.get(c - 97) + 1);
            }
            if(letterMap.get(letterList) == null)
            {
                List<String> matchingWords = new ArrayList<>();
                matchingWords.add(s);
                letterMap.put(letterList, matchingWords);
                
            }
            else
            {
                letterMap.get(letterList).add(s);
            }
        }

        letterMap.forEach((k,v) -> {
            output.add(v);
        });

        return output;
    }
}
