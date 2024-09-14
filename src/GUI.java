import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    //text area
    JFrame window;
    JTextArea textArea;
    boolean wordWrapOn= false;


    //top menue bar
    JScrollPane scrollPane;
    JMenuBar menuBar;

    //fire menue bar
    JMenu menuFile, menuEdit, menuFormat, menuColor ;
    JMenuItem iNew, iSave, iSaveAs,iExit,iOpen;

    //format menu bar
    JMenu menuFont, menuFontSize;
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize10, iFontSize14, iFontSize18, iFontSize24;

    //edit menu bar
    JMenuItem iUndo,iRedo;

    //color menu
    JMenuItem iColor1, iColor2,iColor3;


    Function_File file=new Function_File(this);
    Function_Format format=new Function_Format(this);
    Function_Color color=new Function_Color(this);
    UndoManager um = new UndoManager();
    Function_Edit edit=new Function_Edit(this);



    public static  void main(String[] args){
        new GUI();
    }

    public GUI(){ //constructor
        createWindow();
        createTextArea();
        createMenuBar();
        createFormatMenu();
        createFileMenu();
        createColorMenu();
        createEditMenu();
        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrap();

        color.changeColor("White");



        window.setVisible(true);

    }

    public void createWindow(){ // window creation
       window = new JFrame("VAAYU-pad");
       window.setSize(900,700);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea=new JTextArea();

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

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
    public void createEditMenu(){
        iUndo=new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo=new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
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

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize=new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize10= new JMenuItem("10");
        iFontSize10.addActionListener(this);
        iFontSize10.setActionCommand("size10");
        menuFontSize.add(iFontSize10);

        iFontSize14= new JMenuItem("14");
        iFontSize14.addActionListener(this);
        iFontSize14.setActionCommand("size14");
        menuFontSize.add(iFontSize14);

        iFontSize18= new JMenuItem("18");
        iFontSize18.addActionListener(this);
        iFontSize18.setActionCommand("size18");
        menuFontSize.add(iFontSize18);

        iFontSize24= new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
    }

    public void createColorMenu(){
        iColor1=new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2=new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3=new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
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
            case "Word Wrap": format.wordWrap(); break;
            case "Arial" : format.setFont(command); break;
            case "Comic Sans MS" : format.setFont(command); break;
            case "Times New Roman" : format.setFont(command); break;
            case "size10": format.createFont(10); break;
            case "size14": format.createFont(14); break;
            case "size18": format.createFont(18); break;
            case "size24": format.createFont(24); break;
            case "White": color.changeColor(command);
            case "Black": color.changeColor(command);
            case "Blue": color.changeColor(command);
            case "Undo": edit.undo(); break;
            case "Redo": edit.redo(); break;

        }

    }
}
