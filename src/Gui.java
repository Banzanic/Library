import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui implements ActionListener{
    private JFrame jFrame;
    private JButton loginButton, searchBookButton, myBooksButton, reserveBookButton, addBookButton, deleteBookButton, lendUserBookButton, getBookFromUserButton;
    private JTextField loginTextField;
    private JTextField passwordTextField;
    private JLabel loginLabel;
    private JLabel passwordLabel;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton && loginTextField.getText().equals("admin") && passwordTextField.getText().equals("admin")) {
            adminMenu();
        }
        else if(e.getSource()==loginButton){
            userMenu();
        }
        else if(e.getSource()==searchBookButton){

        }
        else if(e.getSource()==myBooksButton){

        }
        else if(e.getSource()==reserveBookButton){

        }
        else if(e.getSource()==addBookButton){

        }
        else if(e.getSource()==deleteBookButton){

        }
        else if(e.getSource()==lendUserBookButton){

        }
        else if(e.getSource()==getBookFromUserButton){

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
        searchBookButton=new JButton("add a book");
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
}
