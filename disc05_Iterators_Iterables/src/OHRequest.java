public class OHRequest {
    public String description;
    public String name;
    public OHRequest next;

    public OHRequest(String d, String nm, OHRequest n){
        description = d;
        name = nm;
        next = n;
    }
}
