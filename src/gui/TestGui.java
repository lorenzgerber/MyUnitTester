package gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class TestGui {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JButton runButton;
    private JButton clearButton;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JTextField selectedText;
    private JTextArea consoleOutput;
    private JScrollPane scrollPane;

    public TestGui(String title){
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        middlePanel = buildMiddlePanel();
        upperPanel = buildUpperPanel();
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
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
        consoleOutput.setLineWrap(true);
        consoleOutput.setEditable(false);
        scrollPane = new JScrollPane(consoleOutput);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        middlePanel.add(scrollPane);
        

        return middlePanel;
    }

    private JPanel buildUpperPanel(){
        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        selectedText = new JTextField("This is the real shit");
        runButton = new JButton("Run Tests");
        runButton.addActionListener(new ButtonListener(selectedText, consoleOutput));

        upperPanel.add(selectedText);
        upperPanel.add(runButton);
        return upperPanel;
    }

}
