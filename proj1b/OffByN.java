public class OffByN implements CharacterComparator
{
    private int N;
    public OffByN(int pN)
    {
        N = pN;
    }

    @Override
    public boolean equalChars(char x,char y)
    {
        return Math.abs(y - x) == N;
    }


}
