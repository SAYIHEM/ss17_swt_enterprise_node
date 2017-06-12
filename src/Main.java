import java.util.*;

public class Main {

    private static class AbstractUnitImpl extends AbstractUnit {
        public AbstractUnitImpl(String name) {
            super(name);
        }

        @Override
        public Object clone() {
            return null;
        }
    }

    public static void main(String[] args) {

        AbstractUnit unit;
        List<AbstractUnit> childNodes;


        unit = new AbstractUnitImpl("Abstract Unit");
        childNodes = new ArrayList<>();
        childNodes.add(new AbstractUnitImpl("AU1"));
        childNodes.add(new AbstractUnitImpl("AU2"));
        childNodes.add(new AbstractUnitImpl("AU3"));
        childNodes.add(new AbstractUnitImpl("AU4"));
        childNodes.add(new AbstractUnitImpl("AU5"));

        for (AbstractUnit au : childNodes) {

            unit.add(au);
        }

        unit.remove(childNodes.get(0));


    }
}