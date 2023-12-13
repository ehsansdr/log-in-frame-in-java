import lombok.Data;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashMap;

@Data
public class LogFrame extends JFrame implements ActionListener {

    //datas
    private String ID ;
    private String password ;

    HashMap<String, String> ids = new HashMap<>();





    //components:
    JFrame frame = new JFrame();
    JButton acceptBUT = new JButton();
    JPanel panel = new JPanel();
    JButton cancelBUT = new JButton();
    JButton settingsBut = new JButton();
    JLabel idLabel = new JLabel();
    JLabel passwordLabel = new JLabel();

    JTextField textField = new JTextField();
    JLabel descriptionLabel = new JLabel();
    JPasswordField passwordField = new JPasswordField();
    private ImageIcon logo = new ImageIcon("C:\\Users\\lenovo\\Pictures\\GUI\\heart.ggg.png");
    private ImageIcon settingIcon = new ImageIcon("settings-2.png");



    //frame*********************************************************************************************
    private final int WIDTH_FRAME = 400;
    private  int HEIGHT_FRAME = 400;
    private  int X_FRAME = 500 ;
    private  int Y_FRAME = 250;

    //panel button***************************************************************************************
    private  int WIDTH_PANEL = WIDTH_FRAME;
    private  int HEIGHT_PANEL = HEIGHT_FRAME -20;//20 pixels of frame belongs to title
    private  int X_PANEL =  150;
    private  int Y_PANEL = 320;
    private  int FONT_PANEL = 20;

    //accept button**************************************************************************************
    private  int WIDTH_ACCEPT_BUTTON = 100;
    private  int HEIGHT_ACCEPT_BUTTON = 40;
    private  int X_ACCEPT_BUTTON = 265;
    private  int Y_ACCEPT_BUTTON = HEIGHT_PANEL - 70;
    private  int FONT_ACCEPT_BUTTON = 20;
    private Color COLOR_OF_ACCEPT_BUT = new Color(0xC9ADA7);




    //cancel button**************************************************************************************
    private  int WIDTH_CANCEL_BUTTON = WIDTH_ACCEPT_BUTTON;
    private  int HEIGHT_CANCEL_BUTTON = HEIGHT_ACCEPT_BUTTON;
    private  int X_CANCEL_BUTTON =  40;//it is used to be 35 but now i want to be in same X with
    //fields an labels
    private  int Y_CANCEL_BUTTON = Y_ACCEPT_BUTTON;
    private  int FONT_CANCEL_BUTTON = 20;

    private Color COLOR_OF_CANCEL_BUT = new Color(0xF2E9E4);




    private Color COLOR_OF_LABEL = new Color(0x22223B);
    //SETTING button**************************************************************************************
    private  int WIDTH_SETTING_BUTTON = 26;
    private  int HEIGHT_SETTING_BUTTON = 26;
    private  int X_SETTING_BUTTON =  WIDTH_FRAME - 40;
    private  int Y_SETTING_BUTTON = 20;


    private Color COLOR_OF_SETTING_BUT =  COLOR_OF_LABEL;







    //ID label*******************************************************************************************
    private  int FONT_ID_LABEL = 20;
    private  int X_ID_LABEL =  40;
    private  int Y_ID_LABEL = 40;
    private  int WIDTH_ID_LABEL = 40;
    private  int HEIGHT_ID_LABEL = 40;//20 pixels of frame belongs to title
    private Color COLOR_OF_ID_LABEL = new Color(0xF2E9E4);



    //PASSWORD label***************************************************************************************
    private  int FONT_PASSWORD_LABEL = 20;
    private  int X_PASSWORD_LABEL =  40;
    private  int Y_PASSWORD_LABEL = 140;
    private  int WIDTH_PASSWORD_LABEL = 150;
    private  int HEIGHT_PASSWORD_LABEL = 50;//20 pixels of frame belongs to title
    private Color COLOR_OF_PASSWORD_LABEL = new Color(0xF2E9E4);

    //text field*****************************************************************************************
    private  int X_TEXT_FIELD =  X_ID_LABEL;
    private  int Y_TEXT_FIELD =  Y_ID_LABEL + 50 ;
    private  int WIDTH_TEXT_FIELD =   WIDTH_FRAME - 90;
    private  int HEIGHT_TEXT_FIELD =  WIDTH_ID_LABEL - 10;
    private Color COLOR_TEXT_FIELD = new Color(0xF2E9E4);


    //PASSWORD field*****************************************************************************************

    private  int FONT_PASSWORD_FONT = 20;
    private  int X_PASSWORD_FIELD =  X_PASSWORD_LABEL;
    private  int Y_PASSWORD_FIELD =  Y_PASSWORD_LABEL + 50 ;
    private  int WIDTH_PASSWORD_FIELD =  WIDTH_TEXT_FIELD;
    private  int HEIGHT_PASSWORD_FIELD =  HEIGHT_TEXT_FIELD;
    private Color COLOR_PASSWORD_FIELD = new Color(0xF2E9E4);


    //description field*****************************************************************************************

    private  int FONT_descriptionLabel_FONT = 10;
    private  int X_descriptionLabel_FIELD = X_PASSWORD_FIELD + 10 ;
    private  int Y_descriptionLabel_FIELD =  Y_PASSWORD_FIELD + 75 ;
    private  int WIDTH_descriptionLabel_FIELD =  WIDTH_PASSWORD_FIELD - (20*2);
    private  int HEIGHT_descriptionLabel_FIELD =  HEIGHT_TEXT_FIELD * 2;
    private Color COLOR_descriptionLabel_FIELD = new Color(0xFFFFFF);


    public LogFrame(HashMap<String, String>  ids){
        this();
        this.ids = ids;//getting list of ids from main class
    }
    public LogFrame(){



        frame.setTitle("Log in");
        frame.setSize(WIDTH_FRAME + 18, HEIGHT_FRAME + 22);
        frame.setLocation(X_FRAME,Y_FRAME);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(0x003566));
        frame.setIconImage(logo.getImage());
        frame.setLayout(null);

        /**
        frame.setLayout(new GridBagLayout());
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                frame.setShape(new  RoundRectangle2D.Double(0,0,5,6
                        , 20, 20));
            }
        });
        //frame.setShape(new RoundRectangle2D.Double(1,1,863,590,80,80));
        */


        //method running
        acceptButton();
        cancelBUT();
        panel();
        labels();
        feild();
        settingsBut();


        //adding section
        panel.add(acceptBUT);
        panel.add(cancelBUT);
        panel.add(idLabel);
        panel.add(passwordLabel);
        panel.add(textField);
        panel.add(passwordField);
        panel.add(settingsBut);


        frame.add(panel);



    }


    private void settingsBut() {
        settingsBut.setBounds(X_SETTING_BUTTON,Y_SETTING_BUTTON,WIDTH_SETTING_BUTTON,HEIGHT_SETTING_BUTTON);
        settingsBut.setIcon(settingIcon);
        settingsBut.setFocusable(false);
        settingsBut.setOpaque(false);
        settingsBut.setBackground(COLOR_OF_LABEL);
        settingsBut.setBorder(BorderFactory.createBevelBorder(5));
        settingsBut.addActionListener(this);

    }


    private void panel() {
        panel.setBounds(0,0,WIDTH_PANEL,HEIGHT_PANEL);
        panel.setOpaque(true);
        panel.setBackground(COLOR_OF_LABEL);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x4A4E69),5,true));//CREATE THE BORDER WITH TITLE WITH TITLE
        panel.setLayout(null);


    }


    public void acceptButton(){

        acceptBUT.setText("accept");
        acceptBUT.setFont(new Font("JetBrains Mono",Font.BOLD,FONT_CANCEL_BUTTON));
        acceptBUT.setBounds(X_ACCEPT_BUTTON,Y_ACCEPT_BUTTON,WIDTH_ACCEPT_BUTTON,HEIGHT_ACCEPT_BUTTON);
        acceptBUT.setFocusable(false);
        acceptBUT.setBackground(COLOR_OF_ACCEPT_BUT);
        acceptBUT.setHorizontalTextPosition(JButton.CENTER);
        acceptBUT.setVerticalTextPosition(JButton.CENTER);

        acceptBUT.setBorder(BorderFactory.createBevelBorder(2));
        /**
        acceptBUT.setBorder(BorderFactory.createDashedBorder(new Color(0x1B5D5B),
                5,
                20,
                8,
                false
        ));
        */
        acceptBUT.addActionListener(this);


        //Border border =BorderFactory.createLineBorder(new Color(0xDCEA37),10);
        //acceptBUT.setBorder(BorderFactory.createBevelBorder(50,new Color(0xDCEA37),new Color(0x000000)));
        //acceptBUT.setHorizontalAlignment(50);
        //acceptBUT.setVerticalAlignment(5);

    }

    private void cancelBUT() {
        cancelBUT.setText("cancel");
        cancelBUT.setFont(new Font("JetBrains Mono",Font.BOLD,FONT_CANCEL_BUTTON));
        cancelBUT.setBounds(X_CANCEL_BUTTON,Y_CANCEL_BUTTON,WIDTH_CANCEL_BUTTON,HEIGHT_CANCEL_BUTTON);
        cancelBUT.setFocusable(false);
        cancelBUT.setBackground(COLOR_OF_CANCEL_BUT);
        cancelBUT.setHorizontalTextPosition(JButton.CENTER);
        cancelBUT.setVerticalTextPosition(JButton.CENTER);
        /**
        cancelBUT.setBorder(BorderFactory.createDashedBorder(new Color(0x2DB9AD),
                5,
                20,
                8,
                false
                ));
         */
        cancelBUT.addActionListener(this);



    }
    private void descriptionLabel (String warningTxt) throws InterruptedException , Exception {
        this.panel.add(descriptionLabel);//it is essential to be in the first statement
        //unless in first click of accept but description doesn't show

        //detecting the acceptance of user or not to say what to
        if(warningTxt.contains("welcome ")) {
        descriptionLabel.setBounds(X_TEXT_FIELD,
                Y_TEXT_FIELD + 32,
                WIDTH_TEXT_FIELD /2,
                HEIGHT_TEXT_FIELD /2 );


        descriptionLabel.setText(warningTxt);
        descriptionLabel.setForeground(new Color(0x2DB9AD));
        descriptionLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        //this.panel.add(descriptionLabel);
        }

        else if (warningTxt.contains("we don't have ")) {
            descriptionLabel.setBounds(
                    X_TEXT_FIELD,
                    Y_TEXT_FIELD + 32,
                    WIDTH_TEXT_FIELD ,
                    HEIGHT_TEXT_FIELD /2  );



            descriptionLabel.setText(warningTxt);
            descriptionLabel.setForeground(new Color(0xC00029));
            descriptionLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));

            //this.panel.add(descriptionLabel);

        }
        else if(warningTxt.contains("username")){
            descriptionLabel.setBounds(
                    X_PASSWORD_FIELD,
                    Y_PASSWORD_FIELD + 32,
                    WIDTH_PASSWORD_FIELD ,
                    HEIGHT_PASSWORD_FIELD  -10  );

            descriptionLabel.setText(warningTxt);
            descriptionLabel.setForeground(new Color(0xC00029));
            descriptionLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));

           // this.panel.add(descriptionLabel);

        }




    }


    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(e.getSource() == acceptBUT){
            /*************************/
            this.ID = textField.getText();
            this.password = String.valueOf(passwordField.getPassword());
            /*************************/

            if(this.ids.containsKey(this.ID)){
                System.out.println("\nwe have and first if done!");

                if (this.ids.containsValue(this.password) ){
                    descriptionLabel("welcome " + this.ID);
                    System.out.println("yes wellcome "+ this.ID);
                    //changeSizeToSay(); //for changing size to add component or show
                    //user something
                }

                else if (this.password != this.ids.get(this.ID)) {
                    descriptionLabel("username or password is wrong");

                }
            }

            else if (!this.ids.containsKey(this.ID)){
                descriptionLabel("we don't have \"" + this.ID+"\"");
                System.out.println("we dont have "+ this.ID +" here");
                //changeSizeToSay();
            }
            System.out.println("accepted\nID : "+ID+"\npassword : "+ password);
            //frame.dispose();
        }


        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        else if(e.getSource() == cancelBUT){
            System.out.println("cancel");
        }


        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        else if (e.getSource() == settingsBut) {
            settingOperation();

        }


    }

    private void settingOperation() {
        JOptionPane.showMessageDialog(null,"sorry it is constructing");
    }

    private void changeSizeToSay() {
        //value this fiel are conented together for cahnging the position easily
        //and keep the gap between component
        this.HEIGHT_FRAME = 500;
        this.HEIGHT_PANEL = this.HEIGHT_FRAME - 38;//562
        this.Y_ACCEPT_BUTTON = Y_CANCEL_BUTTON = this.HEIGHT_PANEL - 67;

        this.panel.add(descriptionLabel);

        frame.setSize(WIDTH_FRAME + 13,HEIGHT_FRAME);
        panel.setSize(WIDTH_PANEL ,HEIGHT_PANEL);//-2 because of unpredictable disorder
        acceptBUT.setBounds(X_ACCEPT_BUTTON,Y_ACCEPT_BUTTON,WIDTH_ACCEPT_BUTTON,HEIGHT_ACCEPT_BUTTON);
        cancelBUT.setBounds(X_CANCEL_BUTTON,Y_CANCEL_BUTTON,WIDTH_CANCEL_BUTTON,HEIGHT_CANCEL_BUTTON);


    }


    public void labels(){
        idLabel.setText("ID");
        idLabel.setFont(new Font("Arial",Font.BOLD, FONT_ID_LABEL));
        idLabel.setForeground(COLOR_OF_ID_LABEL);
        idLabel.setBounds(X_ID_LABEL,Y_ID_LABEL,WIDTH_ID_LABEL ,HEIGHT_ID_LABEL);
        //idLabel.setBorder(BorderFactory.createTitledBorder("log in"));//CREATE THE BORDER WITH TITLE WITH TITLE


        passwordLabel.setText("PASSWORD");
        passwordLabel.setFont(new Font("Arial",Font.BOLD, FONT_PASSWORD_LABEL));
        passwordLabel.setForeground(COLOR_OF_ID_LABEL);
        passwordLabel.setBounds(X_PASSWORD_LABEL,Y_PASSWORD_LABEL ,WIDTH_PASSWORD_LABEL ,HEIGHT_PASSWORD_LABEL);
    }
    private void feild() {
        textField.setFont((new Font("Arial",Font.PLAIN, FONT_PASSWORD_FONT)));
        textField.setBounds(X_TEXT_FIELD,Y_TEXT_FIELD,WIDTH_TEXT_FIELD,HEIGHT_TEXT_FIELD);
        textField.setBackground(COLOR_TEXT_FIELD);
        textField.setBorder(BorderFactory.createBevelBorder(5));
        textField.setBorder(BorderFactory.createLineBorder(new Color(0x9A8C98),2,false));

        passwordField.setFont((new Font("Arial",Font.PLAIN, FONT_PASSWORD_FONT)));
        passwordField.setBounds(X_PASSWORD_FIELD,Y_PASSWORD_FIELD,WIDTH_PASSWORD_FIELD,HEIGHT_PASSWORD_FIELD);
        passwordField.setBackground(COLOR_PASSWORD_FIELD);
        passwordField.setBorder(BorderFactory.createBevelBorder(5));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(0x9A8C98),2,false));
    }

}
