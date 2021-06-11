public class Palindrome
{
    public Deque<Character> wordToDeque(String word)
    {
        Deque<Character> returnDeque = new ArrayDeque<Character>();
        int length = word.length();
        while (length > 0)
        {
            returnDeque.addFirst(word.charAt(length - 1));
            length--;
        }
        return returnDeque;
    }

    private boolean isPalindrome(Deque<Character> dequeForString)
    {
        if(dequeForString.size() <= 1)
        {
            return true;
        }

        if(dequeForString.removeFirst() == dequeForString.removeLast())
        {
            return isPalindrome(dequeForString);
        }
        else
        {
            return false;
        }

    }


    public boolean isPalindrome(String word)
    {
        Deque<Character> dequeForString = wordToDeque(word);
        return isPalindrome(dequeForString);

    }

    private boolean isPalindrome(Deque<Character> dequeForString,CharacterComparator cc)
    {
        if(dequeForString.size() <= 1)
        {
            return true;
        }
        if(cc.equalChars(dequeForString.removeFirst(), dequeForString.removeLast()))
        {
            return isPalindrome(dequeForString,cc);
        }
        else
        {
            return false;
        }
    }



    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque<Character> dequeForString = wordToDeque(word);

        return isPalindrome(dequeForString, cc);
    }
}


