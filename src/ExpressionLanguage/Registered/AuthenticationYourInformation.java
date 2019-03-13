package ExpressionLanguage.Registered;

public class AuthenticationYourInformation {

    private String name = null;

    private String password01 = null;

    private String password02 = null;

    public void init() {
        this.name = new String();
        this.password01 = new String();
        this.password02 = new String();
    }

    public AuthenticationYourInformation(String name, String password01, String password02) {
        this.init();
        this.setName(name);
        this.setPassword01(password01);
        this.setPassword02(password02);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword01() {
        return password01;
    }

    public void setPassword01(String password01) {
        this.password01 = password01;
    }

    public String getPassword02() {
        return password02;
    }

    public void setPassword02(String password02) {
        this.password02 = password02;
    }




}
