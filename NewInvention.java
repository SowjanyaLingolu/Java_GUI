import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class NewInvention{
    JFrame frame = new JFrame("CrazyTest!");
    JButton button = new JButton("TestUrCraziness");
    String s;
    JLabel label1;
    NewInvention(){
        label1 = new JLabel("Hey Buddy, Tell me Ur name!");
        label1.setBounds(90, 100, 300, 50);
        label1.setFont(new Font("ITALIC", Font.BOLD, 15));
        JTextField tf = new JTextField();
        tf.setBounds(90, 140, 280, 50);
        tf.setFont(new Font("MV Boli", Font.PLAIN, 25));
        tf.setBorder(new LineBorder(Color.black,2));
        tf.setForeground(Color.black);
        tf.setBackground(Color.white);
    
        frame.add(label1);
        frame.add(tf);
        frame.add(button);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        button.setBounds(120, 220, 200, 60);
        button.setFocusable(false);
        button.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 20));
        button.setBackground(Color.pink);
        button.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e){
                button.setBackground(Color.CYAN);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBackground(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(null);
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(null);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.pink);
            }
        });

        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// frame.dispose();
				SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            if (tf.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(tf,"Beware: Please tell me ur name and then start!");
                                new NewInvention();
                            }
                            else{
                                s=tf.getText();
                                new SecondFrame(s);
                            }
                        } catch (SQLException e) {}
                    }
                }); 
			}
		});
        
    }
    public static void main(String[] args){
       new NewInvention();
    }
}
class SecondFrame  {
    JFrame frame;
    JLabel label;
    JRadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    JButton button1,button2;
    ButtonGroup optionGroup;
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    JOptionPane JOptionPane;
    JPanel panel;
    int score=0,cnt=0;
    SecondFrame(String s) throws SQLException{
        frame = new JFrame("Get Started!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setVisible(true);

        label = new JLabel();
        panel = new JPanel();

        radioButton1 = new JRadioButton("A");
        radioButton2 = new JRadioButton("B");
        radioButton3 = new JRadioButton("C");
        radioButton4 = new JRadioButton("D");

        radioButton1.setFocusable(false);
        radioButton2.setFocusable(false);
        radioButton3.setFocusable(false);
        radioButton4.setFocusable(false);

        optionGroup = new ButtonGroup();
        
        button1 = new JButton("Next");
        button2 = new JButton("Submit");
        button1.setFocusable(false);
        button2.setFocusable(false);
        button2.setVisible(false);

        label.setFont(new Font("Cascadia Code", Font.ITALIC, 18));
        button1.setFont(new Font("Times", Font.BOLD, 16));
        button2.setFont(new Font("Times", Font.BOLD, 16));
        radioButton1.setFont(new Font("Cascadia Code", Font.CENTER_BASELINE, 15));
        radioButton2.setFont(new Font("Cascadia Code", Font.CENTER_BASELINE, 15));
        radioButton3.setFont(new Font("Cascadia Code", Font.CENTER_BASELINE, 15));
        radioButton4.setFont(new Font("Cascadia Code", Font.CENTER_BASELINE, 15));


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(20, 120, 1000, 500);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(radioButton1);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(radioButton2);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(radioButton3);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(radioButton4);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(button1);
        panel.add(button2);

        // Add radio buttons to the group
        optionGroup.add(radioButton1);
        optionGroup.add(radioButton2);
        optionGroup.add(radioButton3);
        optionGroup.add(radioButton4);
        
        // Layout
        frame.setLayout(null);
        frame.add(panel);

         button1.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e){
                button1.setBackground(Color.CYAN);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                button1.setBackground(Color.pink);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button1.setBackground(null);
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button1.setBackground(null);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(Color.pink);
            }
        });
        // Action listener for the Next button
        button1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                loadNextQuestion();
            }
        });
        
        ItemListener radioListener = new ItemListener() {
            public void itemStateChanged (ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = getSelectedOption();
                    checkAnswer(selectedOption);
                }
            };
        }; 
        radioButton1.addItemListener(radioListener);
        radioButton2.addItemListener(radioListener);
        radioButton3.addItemListener(radioListener);
        radioButton4.addItemListener(radioListener);
            

         button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showResult(s);
            }
        });
    
        // Database connection
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowji", "root", "L@sowji14");
            String query = "SELECT sno,question, option1, option2, option3, option4,answer FROM manu";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {}

        // Load the first question initially
        loadNextQuestion();
    }
    private void loadNextQuestion() {
        try {
            optionGroup.clearSelection();
            if (resultSet.next()) {
                if(resultSet.isLast()){
                    button1.setVisible(false);
                    button2.setEnabled(true);
                    button2.setVisible(true);
                }
                String No = resultSet.getString("sno");
                String questionText = resultSet.getString("question");
                String optionA = resultSet.getString("option1");
                String optionB = resultSet.getString("option2");
                String optionC = resultSet.getString("option3");
                String optionD = resultSet.getString("option4");

                // Display the question and options in the GUI
                label.setText(No+". "+questionText);
                radioButton1.setText("A. " + optionA);
                radioButton2.setText("B. " + optionB);
                radioButton3.setText("C. " + optionC);
                radioButton4.setText("D. " + optionD);

                cnt++;
            }
        }catch (SQLException ex) {}
     }
    private String getSelectedOption() {
        if (radioButton1.isSelected()) {
            return "A";
        }
        else if (radioButton2.isSelected()) {
            return "B";
        } 
        else if (radioButton3.isSelected()) {
            return "C";
        }
         else if (radioButton4.isSelected()) {
            return "D";
        }
        return null;
    }

     private void checkAnswer(String selectedOption) {
        try {
            String correctAnswer = resultSet.getString("anwswer");

            // Check if the selected answer is correct
            if (selectedOption!=null && correctAnswer.equals(selectedOption)) {
                score++;
                System.out.println(correctAnswer);
            }
        } catch (SQLException ex) {}
    }
    private void showResult(String s){
        if(score<5){
            JOptionPane.showMessageDialog(frame, "Hey " +s+ ", Your Score: " + score+" out of "+cnt+"\n Better luck next time!!", "Score", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(score>5 && score<=9)
        {
            JOptionPane.showMessageDialog(frame, "Hey "+s+", Your Score: " + score+" out of "+cnt+"\n You are a bit closer to achieve full marks!!", "Score", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(frame, "Hey "+s+", Your Score: " + score+" out of "+cnt+"\n Hurrray you reached the target!!!", "Score", JOptionPane.INFORMATION_MESSAGE);
        }
        frame.dispose();
    }
}



