public class Main {
    public static void main(String[] args) {
        System.out.println("--------===Question 1===--------");
        LongestWord longestWord = new LongestWord();
        String result = longestWord.getLongestWord("To 00 hello");
        System.out.println(result);

        System.out.println("\n\n--------===Question 3===--------");
        MovieTitles mt = new MovieTitles();
        String[] titles = mt.getMovieTitles("spiderman");
        for(int i=0;i<titles.length;i++){
            System.out.println(titles[i]);
        }
    }
}
