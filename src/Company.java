public class Company extends AbstractUnit{

    public Company(){

    }

    public Company(String name) throws NullPointerException, IllegalArgumentException{

        if (name == null){
            throw new NullPointerException("Name darf nicht NULL sein!");
        }

        if (name == ""){
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }

        this.name = name;
    }

}
