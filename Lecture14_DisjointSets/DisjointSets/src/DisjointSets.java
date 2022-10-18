public interface DisjointSets {

    /**connects two items p and q*/
    public void connect(int p, int q);

    /**checks to see if two items are connected*/
    public boolean isConnected(int p, int q);
}
