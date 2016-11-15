/*
 * 
 * This file is part of UnitTest.
 *
 * UnitTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * UnitTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with UnitTest.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
/**
 * 
 * @author Lorenz Gerber
 *
 */
public class UnitTestGui {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private JFrame frame;
    private JButton runButton;
    private JButton clearButton;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JTextField selectedText;
    private JTextArea consoleOutput;
    private JScrollPane scrollPane;

    /**
     * 
     * @param title
     */
    public UnitTestGui(String title) {
	frame = new JFrame(title);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	middlePanel = buildMiddlePanel();
	upperPanel = buildUpperPanel();
	lowerPanel = buildLowerPanel();

	frame.add(upperPanel, BorderLayout.NORTH);
	frame.add(middlePanel, BorderLayout.CENTER);
	frame.add(lowerPanel, BorderLayout.SOUTH);

	frame.pack();
    }

    /**
     * 
     */
    public void show() {
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setVisible(true);
    }

    /**
     * 
     * @return
     */
    private JPanel buildLowerPanel() {
	lowerPanel = new JPanel();
	lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	clearButton = new JButton("Clear");
	lowerPanel.add(clearButton);
	return lowerPanel;
    }

    /**
     * 
     * @return
     */
    private JPanel buildMiddlePanel() {
	middlePanel = new JPanel();
	middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	consoleOutput = new JTextArea(20, 30);
	consoleOutput.setLineWrap(true);
	consoleOutput.setEditable(false);
	scrollPane = new JScrollPane(consoleOutput);
	scrollPane.setHorizontalScrollBarPolicy(
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setVerticalScrollBarPolicy(
		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	middlePanel.add(scrollPane);

	return middlePanel;
    }

    /**
     * 
     * @return
     */
    private JPanel buildUpperPanel() {
	upperPanel = new JPanel();
	upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	selectedText = new JTextField("AccountTest", 20);
	runButton = new JButton("Run Tests");

	upperPanel.add(selectedText);
	upperPanel.add(runButton);
	return upperPanel;
    }

    /**
     * 
     * @return
     */
    public JButton getRunButton() {
	return this.runButton;
    }

    /**
     * 
     * @return
     */
    public JButton getClearButton() {
	return this.clearButton;
    }

    /**
     * 
     * @return
     */
    public JTextField getTextField() {
	return this.selectedText;
    }

    /**
     * 
     * @return
     */
    public JTextArea getTextArea() {
	return this.consoleOutput;
    }

}
