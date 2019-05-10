public class LongestWord {
    public String getLongestWord(String sentence){
        String word = "";
        String[] arrayofword = sentence.split(" ");
        for(int i = 0;i<arrayofword.length;i++){
            if(arrayofword.length == 0){
                word = "00";
            }else if(arrayofword[i].length() %2 == 0 && word.length() < arrayofword[i].length()){
                word = arrayofword[i];
            }
        }
        return word;
    }
}
