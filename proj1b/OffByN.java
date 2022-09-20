import java.lang.Math;

public class OffByN implements CharacterComparator{
    int N;
    public OffByN(int x){
        N = x;
    }

    @Override
    public boolean equalChars(char x, char y){
        return (x-y == N) || (x-y == -N);
    };
}
