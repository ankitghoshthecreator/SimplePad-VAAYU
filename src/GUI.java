import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    //text area
    JFrame window;
    JTextArea textArea;

    //top menue bar
    JScrollPane scrollPane;
    JMenuBar menuBar;

    //fire menue bar
    JMenu menuFile, menuEdit, menuFormat, menuColor ;
    JMenuItem iNew, iSave, iSaveAs,iExit,iOpen;

    //format menu bar
    JMenu menuFont, menuFontSize;
    JMenuItem iWrap;

    Function_File file=new Function_File(this);
    Function_Format format=new Function_Format(this);


    public static  void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFormatMenu();
        createFileMenu();


        window.setVisible(true);

    }

    public void createWindow(){ // window creation
       window = new JFrame("VAAYU-pad");
       window.setSize(900,700);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea=new JTextArea();
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// intitalize scroll bar class
        // in the above line we gave the textAres in it so it will be in it included, and we do not need this line window.add(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());


        window.add(scrollPane); // and we add the scrollPane to our window
    }

    public void createMenuBar(){// menue bar added in our pplication
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile=new JMenu("File");
        menuBar.add(menuFile);


        menuFormat=new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor=new JMenu("Color");
        menuBar.add(menuColor);

        menuEdit=new JMenu("Edit");
        menuBar.add(menuEdit);
        //menu bar items done
    }

    public void createFileMenu(){
        iNew=new JMenuItem("New");//create objects
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen=new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave=new JMenuItem("Save");//create objects
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs=new JMenuItem("Save As");//create objects
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit=new JMenuItem("Exit");//create objects
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu(){
        iWrap= new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        menuFontSize=new JMenu("Font Size");
        menuFormat.add(menuFontSize);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command= e.getActionCommand();

        switch (command){
            case "New": file.newCreate(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "SaveAs": file.saveAs(); break;
            case "Exit": file.exit(); break;


        }

    }
}
