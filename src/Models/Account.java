package Models;

public abstract class Account {
    private int accountID;
    private String name;
    private String username;
    private String password;
    private String email;


    public Account(String name, String username, String password, String email){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account() {
        this.name = "";
        this.username = "";
        this.password = "";
        this.email = "";
    }

    public Account(Account account) {
        this.accountID = account.accountID;
        this.name = account.name;
        this.username = account.username;
        this.password = account.password;
        this.email = account.email;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



//    public abstract void readAccount();

}
