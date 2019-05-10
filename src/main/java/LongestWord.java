public class LongestWord {
    public String getLongestWord(String sentence){
        String word = "";
        String[] arrayofword = sentence.split(" ");
        for(int i = 0;i<arrayofword.length;i++){
            if(arrayofword[i].length() %2 == 0 && word.length() < arrayofword[i].length()){
                word = arrayofword[i];
            }else if(word == ""){
                word = "00";
            }
        }
        return word;
    }
}