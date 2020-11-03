package animals;

public class Kitten extends Cat{
    private final static String GENDER = "Female";

    public Kitten(String name, int age){
        super(name, age, GENDER);
    }

    public static String getGENDER() {
        return GENDER;
    }

    @Override
    public String produceSound(){
        return "Meow";
    }
}
