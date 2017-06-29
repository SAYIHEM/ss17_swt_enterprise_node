import java.util.*;

public abstract class AbstractUnit extends AbstractEnterpriseUnit {

    private int count = 0;

    private Set<AbstractEnterpriseUnit> childNodes = new HashSet<AbstractEnterpriseUnit>();

    public AbstractUnit(){

    }

    public AbstractUnit(String name) throws NullPointerException, IllegalArgumentException{

        if (name == null){
            throw new NullPointerException("Name darf nicht NULL sein!");
        }

        if (name == ""){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }

        this.name = name;
    }

    public void add(AbstractEnterpriseUnit childNode) throws NullPointerException{

        if (childNode == null){
            throw new NullPointerException("ChildNode darf nicht NULL sein!");
        }

        if (!this.childNodes.contains(childNode)){

            this.childNodes.add(childNode);
        }
    }

    public boolean remove(AbstractEnterpriseUnit childNode) throws NullPointerException {

        if (childNode == null){
            throw new NullPointerException("ChildNode darf nicht NULL sein!");
        }

        if (this.childNodes.contains(childNode)) {

            this.childNodes.remove(childNode);
            return true;

        } else {

            return false;
        }
    }

    public List<AbstractEnterpriseUnit> getChildNodes(){

        List<AbstractEnterpriseUnit> childNodes = new LinkedList<AbstractEnterpriseUnit>();

        for (Iterator<AbstractEnterpriseUnit> it = this.childNodes.iterator(); it.hasNext();){

            childNodes.add(it.next());
        }
        return childNodes;
    }
}
