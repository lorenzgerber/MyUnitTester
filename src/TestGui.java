import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class TestGui {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JButton runButton;
    private JButton clearButton;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JTextField selectedTest;
    private JTextArea consoleOutput;

    public TestGui(String title){
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        upperPanel = buildUpperPanel();
        middlePanel = buildMiddlePanel();
        lowerPanel = buildLowerPanel();

        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(lowerPanel,  BorderLayout.SOUTH);


        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItem = new JMenuItem("Open new Class");
        menu.add(menuItem);
        frame.setJMenuBar(menuBar);

        frame.pack();
    }

    public void show(){
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private JPanel buildLowerPanel(){
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        clearButton = new JButton("Clear");
        lowerPanel.add(clearButton);
        return lowerPanel;
    }

    private JPanel buildMiddlePanel(){
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        consoleOutput = new JTextArea(20,30);
        middlePanel.add(consoleOutput);

        return middlePanel;
    }

    private JPanel buildUpperPanel(){
        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        selectedTest = new JTextField(10);
        runButton = new JButton("Run Tests");
        upperPanel.add(selectedTest);
        upperPanel.add(runButton);
        return upperPanel;
    }

}
