import practice2_package.*;


public class WordUtils{

    /*Could overload (make two functions with different calls to AList and SLLists
    * too long, ugly looking, more to change in updates*/
    public static String longest(List61B<String> L){

        int longest = 0;
        int len = L.size();
        for (int i = 0; i < len;i++){
            String longest_string = L.get(longest);
            String current_string = L.get(i);
            if (longest_string.length() < current_string.length()){
                longest = i;
            }
        }
        return L.get(longest);
    }

}
