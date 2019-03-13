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

    /**
     * 验证用户名长度小于20
     * @return
     */
    public boolean judegNameLongth() {
        boolean key = false;

        if (this.getName().length() >= 20) {
            key = false;
        } else {
            key = true;
        }

        return key;
    }

    /**
     * 验证密码长度小于10
     * @return
     */
    public boolean judegPasswordLongth() {
        boolean key = false;

        if (this.getPassword01().length() >= 10) {
            key = false;
        } else {
            key = true;
        }

        return key;
    }

    /**
     * 验证密码是否一一致
     * @return
     */
    public boolean judegPasswordSame() {
        boolean key = false;

        if(this.getPassword01().equals(this.getPassword02())) {
            key = true;
        } else {
            key = false;
        }

        return key;
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


    /**
     * 判断用户注册信息的合法性
     *
     * 0：合法
     * 1：用户名太长
     * 2：用户密码太长
     * 3：用户密码不一致
     *
     * @return
     */
    public int canUsed() {
        int key = 0;
        // 用户名长度
        boolean key01 = this.judegNameLongth();
        // 用户密码长度
        boolean key02 = this.judegPasswordLongth();
        // 用户密码一致性
        boolean key03 = this.judegPasswordSame();

        if (key01 == true) {
            if (key02 == true) {
                if (key03 == true) {
                    key = 0;
                } else {
                    key = 3;
                    // 用户密码不一致
                }
            } else {
                key = 2;
                // 用户密码太长
            }
        } else {
            key = 1;
            // 用户名太长
        }
        return key;
    }


}
