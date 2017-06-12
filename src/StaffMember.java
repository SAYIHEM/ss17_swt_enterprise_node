import java.util.*;

public class StaffMember implements EnterpriseNode, Comparable<StaffMember>{

    protected String name;
    protected String job;
    protected Set<StaffMember> directSubordinates = new TreeSet<StaffMember>();

    public StaffMember(){

    }

    public StaffMember(String name, String job) throws NullPointerException, IllegalArgumentException{

        if (name == null || job == null){
            throw new NullPointerException("Name oder Job darf nicht NULL sein!");
        }

        if (name == "" || job == ""){
            throw new IllegalArgumentException("Name oder Job darf nicht leer sein!");
        }

        this.name = name;
        this.job = job;
    }

    public String getJob(){

        return this.job;
    }

    public String getName(){

        return this.name;
    }

    public boolean addDirectSubordinate(StaffMember subordinate){

        if (subordinate == null){
            throw new NullPointerException("ChildNode darf nicht NULL sein!");
        }

        return this.directSubordinates.add(subordinate);
    }

    public boolean removeDirectSubordinate(StaffMember subordinate){

        if (subordinate == null){
            throw new NullPointerException("ChildNode darf nicht NULL sein!");
        }

        return this.directSubordinates.remove(subordinate);
    }

    public Set<StaffMember> getDirectSubordinates(){

        return directSubordinates;
    }

    public String toString(){

        return this.name;
    }

    public int compareTo(StaffMember staffMember) throws NullPointerException{

        if (staffMember == null){
            throw new NullPointerException("Zu Vergleichender Name des StaffMembers darf nicht leer sein!");
        }

        return this.name.compareTo(staffMember.getName());
    }
}
