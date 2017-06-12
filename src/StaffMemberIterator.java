import java.util.*;

public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember>{

    private Set<StaffMember> allMembers;
    private Iterator<StaffMember> iterator;

    public StaffMemberIterator(){}

    public StaffMemberIterator(Set<StaffMember> directSubordinates) throws NullPointerException{

        Set<StaffMember> helper = new TreeSet<StaffMember>();

        if (directSubordinates == null){
            throw new NullPointerException("directSubordinates darf nicht NULL sein!");
        }

        this.allMembers = directSubordinates;

        Set<StaffMember> helper1 = new TreeSet<StaffMember>();

        for (Iterator<StaffMember> it = this.allMembers.iterator(); it.hasNext();){

            helper.addAll(findSubordinatesRecursivly(it.next(), helper1));

        }

        this.allMembers.addAll(helper);


        // Sortieren der Liste -> Umwandeln zu Set
        StaffMember[] sortingArray = new StaffMember[this.allMembers.size()];
        sortingArray = this.allMembers.toArray(sortingArray);

        List<StaffMember> sortingList = new LinkedList<StaffMember>();

        for (int i = 0; i < sortingArray.length; i++){

            sortingList.add(sortingArray[i]);
        }

        Collections.sort(sortingList);

        this.allMembers.clear();
        this.allMembers.addAll(sortingList);


        this.iterator = this.allMembers.iterator();

        for (Iterator<StaffMember> iter = this.allMembers.iterator(); iter.hasNext();){

            System.out.println(iter.next().getName());
        }
    }

    private Set<StaffMember> findSubordinatesRecursivly(StaffMember member, Set<StaffMember> helper){

        if (member.getDirectSubordinates().isEmpty()){

            return helper;
        }
        else {

            helper.addAll(member.getDirectSubordinates());

            for (Iterator<StaffMember> it = member.getDirectSubordinates().iterator(); it.hasNext();){

                findSubordinatesRecursivly(it.next(), helper);
            }


            return helper;
        }
    }

    public boolean hasNext() {

        return iterator.hasNext();
    }

    public StaffMember next() throws NoSuchElementException{

        return iterator.next();


//        if (this.it < this.allMembers.size()){
//
//            StaffMember[] members = new StaffMember[this.allMembers.size()];
//            members = this.allMembers.toArray(members);
//
//            StaffMember helper = members[this.it];
//            this.it++;
//            return helper;
//        }
//        else {
//            throw new NoSuchElementException("");
//        }
    }
}
