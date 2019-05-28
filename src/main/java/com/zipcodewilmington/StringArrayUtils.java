package com.zipcodewilmington;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String thisOne : array) if (thisOne.equals(value)) return true;
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int length = array.length;
        String[] revCopy = new String[length];
        for(int i=0;i<length;i++) revCopy[length-i-1]=array[i];
        return revCopy;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        Integer toCheck = (array.length-(array.length%2))/2;
        for(Integer i=0;i<toCheck;i++) if (!array[i].equals(array[array.length-1-i]))return false;
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
   //     for(String thisOne:array) thisOne=thisOne.toLowerCase();
        Boolean[] myAlphabet = new Boolean[26];
        Arrays.fill(myAlphabet,false);
        for(String thisString:array){
            thisString=thisString.toLowerCase();
            char[] myChars = thisString.toCharArray();
            for (char thisChar:myChars) {
                if(Character.isLetter(thisChar)) myAlphabet[thisChar-'a']=true;
            }
        }
        for(Boolean thisLetter:myAlphabet) if(thisLetter==false)return false;
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        Integer occurrences=0;
            for(String thisString:array){
                for(int i=0;i<thisString.length()+1-value.length();i++){
                    if(value.equals(thisString.substring(i,i+value.length())))occurrences++;
                }
            }
        return occurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        for(int i=0;i<array.length;i++){
            if(array[i].equals(valueToRemove)){
                array= removeStringAtIndex(array,i);
            }
        }
        return array;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        for(int i=1;i<array.length;i++){
            while(i<array.length&&array[i].equals(array[i-1])){
                array=removeStringAtIndex(array,i);
            }
        }
        return array;
    }

    public static String[] removeStringAtIndex(String[] orig,Integer index){
        String[] newArray = new String[orig.length-1];
        for(int i=0;i<index;i++)newArray[i]=orig[i];
        for(int i=index;i<orig.length-1;i++)newArray[i]=orig[i+1];
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String packMatch=array[0];
        ArrayList<String> newArrayList = new ArrayList<String>(1);
        StringBuilder myBuilder=new StringBuilder(packMatch);
        for(int i=1;i<array.length;i++){
            if(array[i].equals(packMatch))myBuilder.append(array[i]);
            else{
                newArrayList.add(myBuilder.toString());
                packMatch=array[i];
                myBuilder = new StringBuilder(packMatch);
            }
        }
        newArrayList.add(myBuilder.toString());
        return newArrayList.toArray(new String[newArrayList.size()]);
    }
}
