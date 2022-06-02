public class Account {
    AccountType accountType;
    private String login;
    private String password;
    Account(AccountType accountType, String login, String password){
        this.accountType=accountType;
        this.login=login;
        this.password=password;
    }
    public AccountType getAccountType(){
        return accountType;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
}
