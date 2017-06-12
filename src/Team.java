import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Team extends AbstractEnterpriseUnit {

    protected StaffMember teamLeader;

    public Team(){

    }


    public Team(String name, StaffMember teamLeader){

        if (name == null || teamLeader == null){
            throw new NullPointerException("Name oder Teamleader darf nicht NULL sein!");
        }

        if (name == ""){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }

        this.name = name;
        this.teamLeader = teamLeader;
    }

    public StaffMember getTeamLeader(){

        return this.teamLeader;
    }

    private List<StaffMember> recursiveGetTeamMembers(StaffMember member){

        List<StaffMember> teamMebers = new LinkedList<StaffMember>();
        StaffMember helper;

        if (!member.getDirectSubordinates().isEmpty()) {

            for (Iterator<StaffMember> it = member.getDirectSubordinates().iterator(); it.hasNext();){

                helper = it.next();
                teamMebers.add(helper);

                teamMebers.addAll(recursiveGetTeamMembers(helper));
            }
            return teamMebers;
        } else {

            return teamMebers;
        }
    }

    public List<StaffMember> getTeamMembers(){

        List<StaffMember> teamMebers = new LinkedList<StaffMember>();
        StaffMember helper;

        teamMebers.add(teamLeader);

        if (!this.teamLeader.getDirectSubordinates().isEmpty()){

            for (Iterator<StaffMember> it = this.teamLeader.getDirectSubordinates().iterator(); it.hasNext();){

                helper = it.next();
                teamMebers.add(helper);

                teamMebers.addAll(recursiveGetTeamMembers(helper));
            }

            Collections.sort(teamMebers);
            return teamMebers;
        }
        else {

            return teamMebers;
        }
    }
}
