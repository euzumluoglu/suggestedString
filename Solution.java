package de.based.solution;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private static final int MAX_TOKEN = 3;

    public static void main(String[] args){
        String[] maskedArray= {"the",".","yes","no","and","is","at","in","to"};
        String[] seachArray= {"The","weather","is","nice",".","Nobody","likes","to","stay","at","home","in","these","days",".","You","should","go","outside","too","."};
        List<String> suggestedMessages = suggestedMessages(Lists.newArrayList(seachArray),new HashSet<String>(Arrays.asList(maskedArray)));
        for(String suggestions:suggestedMessages){
            System.out.println(suggestions);
        }
    }

    public static List<String> suggestedMessages(List<String> searchList, Set<String> maskedSet){
        List<String> suggestList = new ArrayList<String>();
        for(int i=0; i<searchList.size(); i++){
            suggestList = buildSuggestions(MAX_TOKEN,i,searchList,suggestList,maskedSet);
        }
        return suggestList;
    }

    private static boolean isMaskedWord(String word, Set<String> maskedList){
        return word!=null && !word.isEmpty() && word.length()>1 && !maskedList.contains(word.toLowerCase());
    }

    private static List<String> buildSuggestions(int token,int position,List<String> words, List<String> suggestionList,Set<String> maskedList){

        String prevString = null;
        while(position<words.size() && token>0){
            if(!isMaskedWord(words.get(position),maskedList)){
                break;
            }
            if(prevString==null){
                prevString = words.get(position);
            } else {
                prevString = prevString + " " + words.get(position);
            }
            suggestionList.add(prevString);
            position++;
            token--;
        }

        return suggestionList;
    }
}
