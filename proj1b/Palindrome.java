

public class Palindrome {

    public Deque<Character> wordToDeque(String Word){
//        Deque<Character> L = new ArrayDeque<>();
        Deque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < Word.length(); i++){
            L.addLast(Word.charAt(i));
        }
        return L;
    }

    public boolean isPalindrome(String word){
        Deque<Character> L = wordToDeque(word);
        return isPalindromeHelper(L);
    }

    private boolean isPalindromeHelper(Deque<Character> L){
        if (L.size() == 0 || L.size() == 1){
            return true;
        } else {
            char front = L.removeFirst();
            char back = L.removeLast();
            return (front == back) && isPalindromeHelper(L);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> L = wordToDeque(word);
        return isPalindromeHelper(L,cc);
    }

    private boolean isPalindromeHelper(Deque<Character> L, CharacterComparator cc){
        if (L.size() == 0 || L.size() == 1){
            return true;
        } else {
            char front = L.removeFirst();
            char back = L.removeLast();
            return cc.equalChars(front, back) && isPalindromeHelper(L);
        }
    }


/**THIS IS MY ORIGINAL SOLUTION, IT WORKS BUT THE ABOVE ONE IS WAY BETTER**/
//    public boolean isPalindrome(String word){
//        Deque<Character> L = wordToDeque(word);
//        String flipped = flip(L);
//        if (word.equals(flipped)){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isPalindrome(String word, CharacterComparator cc){
//        Deque<Character> L = wordToDeque(word);
//        String flipped = flip(L);
//        for (int i = 0; i < word.length(); i++){
//           if (cc.equalChars(word.charAt(i), flipped.charAt(i)) != true){
//               return false;
//           }
//        }
//        return true;
//    }
//
//    public String flip(Deque<Character> L){
//        if (L.size() == 1){
//            return L.removeLast().toString();
//        } else {
//            return L.removeLast().toString() + flip(L);
//        }
//    }
}
