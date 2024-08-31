import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    public static  void main(String[] args){


        new GUI();

    }
    public GUI(){
        createWindow();
        createTextArea();


        window.setVisible(true);

    }

    public void createWindow(){ // window creation
       window = new JFrame("VAAYU-pad");
       window.setSize(900,700);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea=new JTextArea();
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // in the above line we gave the textAres in it so it will be in it included and we do not need this line window.add(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());


        window.add(scrollPane); // and we add the scrollPane to our window

    }


}
