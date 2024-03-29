import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Gui implements ActionListener{
    private Catalog catalog;
    private JFrame jFrame;
    private JButton loginButton, searchBookButton, myBooksButton, reserveBookButton, addBookButton, deleteBookButton, lendUserBookButton, getBookFromUserButton, searchTitleButton, addButton, reserveButton, lendButton, backLoginButton, backAdminMenuButton, backUserMenuButton, backSearchMenuButton;
    private JTextField loginTextField, passwordTextField, searchTitleTextField, addAuthorTextField, addTitleTextField, addISBNTextField;
    private JLabel loginLabel, passwordLabel, addAuthorLabel, addTitleLabel, addISBNLabel;
    private JTable jTable;
    private JScrollPane scrollPanel;
    private JPanel contentPanel;
    private LinkedList<Account> accounts;
    private LinkedList<Copy> copies;
    private User user;
    private Admin admin;
    Gui(){
        loginMenu();
    }
    public void loginMenu(){
        jFrame=new JFrame("login");
        jFrame.setSize(500,250);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        loginButton=new JButton("sign in");
        loginButton.setBounds(210,150,80,30);
        loginButton.addActionListener(this);
        loginTextField = new JTextField();
        loginTextField.setBounds(120,50,260,30);
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(120,100,260,30);
        loginLabel = new JLabel("login:");
        loginLabel.setBounds(80,50,80,30);
        passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(50,100,80,30);
        jFrame.add(loginButton);
        jFrame.add(loginTextField);
        jFrame.add(passwordTextField);
        jFrame.add(loginLabel);
        jFrame.add(passwordLabel);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        init();
    }
    public void init(){
        accounts=new LinkedList<>();
        accounts.add(new User(AccountType.USER,"user","user"));
        accounts.add(new Admin(AccountType.ADMIN,"admin","admin"));
        catalog=new Catalog();
        catalog.addBook("Pan Tadeusz", 6543356, new Author("Adam Mickiewicz"));
        catalog.addBook("Kordian", 1234123, new Author("Juliusz Słowacki"));
        catalog.addBook("Lalka", 454332, new Author("Bolesław Prus"));
        catalog.addBook("Quo Vadis", 743534, new Author("Henryk Sienkiewicz"));
        catalog.addBook("Wesele", 87634, new Author("Stanisław Wyspiański"));
        catalog.addBook("Dziady I", 56803, new Author("Adam Mickiewicz"));
        catalog.addBook("Dziady II", 2347542, new Author("Adam Mickiewicz"));
        catalog.addBook("Dziady III", 655787, new Author("Adam Mickiewicz"));
        catalog.addBook("Dziady IV", 234672, new Author("Adam Mickiewicz"));
        catalog.addBook("Sklepy Cynamonowe", 12345678, new Author("Bruno Schulz"));
        catalog.addBook("Ferdydurke", 2856756, new Author("Witold Gombrowicz"));
        catalog.addBook("Zemsta", 43526, new Author("Aleksander Fredro"));
        catalog.addBook("Krzyżacy", 8532145, new Author("Henryk Sienkiewicz"));
        catalog.addBook("Przedwiośnie", 743435, new Author("Stefan Żeromski"));
        catalog.addBook("Zdążyć przed Panem Bogiem", 323267, new Author("Hanna Krall"));
        for(int i=0;i<catalog.getListOfAllBooks().size();i++){
            catalog.getListOfAllBooks().get(i).addCopy();
            catalog.getListOfAllBooks().get(i).addCopy();
            catalog.getListOfAllBooks().get(i).addCopy();
        }
        copies=new LinkedList<>();
        for(int i=0;i<catalog.getListOfAllBooks().size();i++){
            Book temp=catalog.getListOfAllBooks().get(i);
            for(int j=0;j<temp.getListOfAllCopies().size();j++){
                copies.add(temp.getListOfAllCopies().get(j));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton) {
            for(int i=0;i<accounts.size();i++){
                if(loginTextField.getText().equals(accounts.get(i).getLogin()) && passwordTextField.getText().equals(accounts.get(i).getPassword()) && accounts.get(i).getAccountType()==AccountType.ADMIN){
                    adminMenu();
                    admin= (Admin) accounts.get(i);
                    user=null;
                }
                else if(loginTextField.getText().equals(accounts.get(i).getLogin()) && passwordTextField.getText().equals(accounts.get(i).getPassword()) && accounts.get(i).getAccountType()==AccountType.USER){
                    userMenu();
                    user= (User) accounts.get(i);
                    admin=null;
                }
            }
        }
        else if(e.getSource()==searchBookButton){
            searchMenu();
        }
        else if(e.getSource()==myBooksButton){

        }
        else if(e.getSource()==reserveBookButton){
            reserveBookMenu();
        }
        else if(e.getSource()==addBookButton){
            addBookMenu();
        }
        else if(e.getSource()==deleteBookButton){

        }
        else if(e.getSource()==lendUserBookButton){
            lendUserBookMenu();
        }
        else if(e.getSource()==getBookFromUserButton){

        }
        else if(e.getSource()==searchTitleButton){
            searchTitleMenu();
        }
        else if(e.getSource()==addButton){
            catalog.getListOfAllBooks().add(new Book(addTitleTextField.getText(),Integer.parseInt(addISBNTextField.getText()),new Author(addAuthorTextField.getText())));
            catalog.getListOfAllBooks().get(catalog.getListOfAllBooks().size()-1).addCopy();
            displayBooks();
        }
        else if(e.getSource()==reserveButton){
            reserveBook();
        }
        else if(e.getSource()==lendButton){
            lendBook();
        }
        else if(e.getSource()==backAdminMenuButton){
            adminMenu();
        }
    }
    public void userMenu(){
        jFrame.dispose();
        jFrame.removeAll();
        jFrame=new JFrame("user menu");
        jFrame.setSize(700,250);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        searchBookButton=new JButton("search for a book");
        searchBookButton.setBounds(55,75,160,50);
        searchBookButton.addActionListener(this);
        myBooksButton=new JButton("view my books");
        myBooksButton.setBounds(270,75,160,50);
        myBooksButton.addActionListener(this);
        reserveBookButton=new JButton("reserve a book");
        reserveBookButton.setBounds(485,75,160,50);
        reserveBookButton.addActionListener(this);
        jFrame.add(searchBookButton);
        jFrame.add(myBooksButton);
        jFrame.add(reserveBookButton);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
    public void adminMenu(){
        jFrame.dispose();
        jFrame.removeAll();
        jFrame=new JFrame("admin menu");
        jFrame.setSize(700,250);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addBookButton=new JButton("add a book");
        addBookButton.setBounds(10,30,150,50);
        addBookButton.addActionListener(this);
        deleteBookButton=new JButton("delete a book");
        deleteBookButton.setBounds(180,30,150,50);
        deleteBookButton.addActionListener(this);
        lendUserBookButton=new JButton("lend a book");
        lendUserBookButton.setBounds(350,30,150,50);
        lendUserBookButton.addActionListener(this);
        getBookFromUserButton=new JButton("get a book");
        getBookFromUserButton.setBounds(520,30,150,50);
        getBookFromUserButton.addActionListener(this);
        searchBookButton=new JButton("search a book");
        searchBookButton.setBounds(10,100,150,50);
        searchBookButton.addActionListener(this);

        jFrame.add(addBookButton);
        jFrame.add(deleteBookButton);
        jFrame.add(lendUserBookButton);
        jFrame.add(getBookFromUserButton);
        jFrame.add(searchBookButton);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }

    public void displayBooks(){
        Object[][] rows = new Object[copies.size()][];
        Object[] row;
        for(int i=0;i<copies.size();i++){
            row = new Object[5];
            row[0] = copies.get(i).getAuthor().getName();
            row[1] = copies.get(i).getTitle();
            row[2] = copies.get(i).getIsbn();
            row[3] = copies.get(i).getId();
            row[4] = copies.get(i).getStatus();
            rows[i] = row;
        }
        String[] column= {"Author","Title","ISBN", "ID", "Status"};
        setJTable(rows,column);
    }

    public void searchMenu(){
        displayBooks();
        jFrame.resize(700,300);
        JLabel searchTitleLabel=new JLabel("Title:");
        searchTitleLabel.setBounds(30,200,100,30);
        searchTitleTextField = new JTextField();
        searchTitleTextField.setBounds(70,200,200,30);
        searchTitleButton=new JButton("search");
        searchTitleButton.setBounds(290,200,80,30);
        searchTitleButton.addActionListener(this);
        jFrame.add(searchTitleLabel);
        jFrame.add(searchTitleTextField);
        jFrame.add(searchTitleButton);
    }

    public void searchTitleMenu(){
        LinkedList<Object[]> rowsList=new LinkedList<>();
        Object[] row;
        for(int i=0;i<copies.size();i++){
            if(copies.get(i).getTitle().equalsIgnoreCase(searchTitleTextField.getText())) {
                row = new Object[5];
                row[0] = copies.get(i).getAuthor().getName();
                row[1] = copies.get(i).getTitle();
                row[2] = copies.get(i).getIsbn();
                row[3] = copies.get(i).getId();
                row[4] = copies.get(i).getStatus();
                rowsList.add(row);
            }
        }
        Object[][] rowsArray = new Object[rowsList.size()][];
        for(int i=0;i<rowsList.size();i++){
            rowsArray[i]= rowsList.get(i);
        }
        String[] column= {"Author","Title","ISBN", "ID", "Status"};
        setJTable(rowsArray,column);
    }

    public void setJTable(Object[][] rows ,String[] column){
        jTable = new JTable(rows, column);
        jFrame.dispose();
        jFrame.removeAll();
        jFrame=new JFrame("display books");
        jFrame.setSize(700,300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jFrame.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        scrollPanel = new JScrollPane();
        scrollPanel.setBounds(30, 30, 600, 150);
        contentPanel.add(scrollPanel);
        scrollPanel.setViewportView(jTable);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }

    public void addBookMenu(){
        displayBooks();
        jFrame.resize(700,300);
        addAuthorLabel=new JLabel("Author:");
        addAuthorLabel.setBounds(20,200,70,30);
        addTitleLabel=new JLabel("Title:");
        addTitleLabel.setBounds(190,200,70,30);
        addISBNLabel=new JLabel("ISBN:");
        addISBNLabel.setBounds(340,200,70,30);
        addAuthorTextField=new JTextField();
        addAuthorTextField.setBounds(70,200,100,30);
        addTitleTextField=new JTextField();
        addTitleTextField.setBounds(225,200,100,30);
        addISBNTextField=new JTextField();
        addISBNTextField.setBounds(380,200,100,30);
        addButton=new JButton("add");
        addButton.setBounds(495,200,80,30);
        addButton.addActionListener(this);
        backAdminMenuButton=new JButton("back");
        backAdminMenuButton.setBounds(590,200,80,30);
        backAdminMenuButton.addActionListener(this);
        jFrame.add(backAdminMenuButton);
        jFrame.add(addAuthorLabel);
        jFrame.add(addTitleLabel);
        jFrame.add(addISBNLabel);
        jFrame.add(addAuthorTextField);
        jFrame.add(addTitleTextField);
        jFrame.add(addISBNTextField);
        jFrame.add(addButton);
    }
    public void reserveBookMenu(){
        displayBooks();
        jFrame.resize(700,300);
        reserveButton=new JButton("reserve");
        reserveButton.setBounds(30,200,80,30);
        reserveButton.addActionListener(this);
        jFrame.add(reserveButton);
    }
    public void reserveBook(){
        if(user.getReserveMyBooks().size()<3) {
            Copy copy = copies.get(jTable.getSelectedRow());
            if(copy.getStatus()==CopyStatus.AVAILABLE) {
                copy.setStatus(CopyStatus.RESERVED);
                user.addBookToReserveMyBooks(copy);
                reserveBookMenu();
            }
        }
    }
    public void lendUserBookMenu(){
        displayBooks();
        jFrame.resize(700,300);
        lendButton=new JButton("lend");
        lendButton.setBounds(30,200,80,30);
        lendButton.addActionListener(this);
        backAdminMenuButton=new JButton("back");
        backAdminMenuButton.setBounds(550,200,80,30);
        backAdminMenuButton.addActionListener(this);
        jFrame.add(backAdminMenuButton);
        jFrame.add(lendButton);
    }
    public void lendBook(){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountType()==AccountType.USER){
                user= (User) accounts.get(i);
                Copy copy = copies.get(jTable.getSelectedRow());
                if(user.getReserveMyBooks().contains(copy) && user.getMyBooks().size()<3){
                    user.getReserveMyBooks().remove(copy);
                    user.getMyBooks().add(copy);
                    copy.setStatus(CopyStatus.LOANED);
                    lendUserBookMenu();
                }
            }
        }
    }
}
