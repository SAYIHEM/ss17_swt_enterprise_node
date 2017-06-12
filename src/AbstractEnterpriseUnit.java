public abstract class AbstractEnterpriseUnit implements EnterpriseNode, Comparable, Cloneable {

    protected String name;

    public AbstractEnterpriseUnit(){

    }

    public AbstractEnterpriseUnit(String name) throws NullPointerException, IllegalArgumentException{

        if (name == null){
            throw new NullPointerException("Name darf nicht NULL sein!");
        }

        if (name == ""){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }

        this.name = name;
    }

    public String getName(){

        return this.name;
    }

    public boolean equals(AbstractEnterpriseUnit o){

        return o.getName().equals(this.name);
    }

    @Override
    public int compareTo(Object object) {

        AbstractEnterpriseUnit unit = null;

        if (object instanceof AbstractEnterpriseUnit) {

            if (this.name.equals(((AbstractEnterpriseUnit) object).getName())) {

                return 0;

            } else {

                return 1;
            }

        } else {

            return 1;
        }
    }

    public Object clone() {


        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
