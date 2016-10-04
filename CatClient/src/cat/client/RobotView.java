package cat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import cat.function.Robot;
import cat.util.CatUtil;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RobotView extends JFrame{

	private JPanel contentPane;
	String info ;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	
	public RobotView() {
		setVisible(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(890, 100, 330, 517);
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
					g.drawImage(new ImageIcon("images/iii.jpg").getImage(),0,0, getWidth(), getHeight(),null);
			}
		};
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 294, 327);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 347, 294, 98);
		contentPane.add(scrollPane_1);
		
		textPane_1 = new JTextPane();
		textPane_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){					
					sendMessage();
				}
			}
		});
		scrollPane_1.setViewportView(textPane_1);
		
		button = new JButton("发送");
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();
			}
		});
		button.setBounds(238, 450, 66, 23);
		contentPane.add(button);
		
		button_1 = new JButton("离开");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RobotView.this.dispose();
			}
		});
		button_1.setBounds(162, 450, 66, 23);
		contentPane.add(button_1);
		
	
	}
	
	public void sendMessage() {
		info=Robot.getResponse(textPane_1.getText());
		if(info!=null){
			try {
				SimpleAttributeSet attrset =new SimpleAttributeSet();
				StyleConstants.setBold(attrset, true);
				StyleConstants.setItalic(attrset, false);
				StyleConstants.setFontSize(attrset, 15);
				StyleConstants.setFontFamily(attrset,"方正兰亭超细黑简体");
				
				SimpleAttributeSet attrset1 =new SimpleAttributeSet();
				StyleConstants.setBold(attrset1, true);
				StyleConstants.setItalic(attrset1, false);
				StyleConstants.setFontSize(attrset1, 12);
				StyleConstants.setFontFamily(attrset,"新宋体");
				
				StyleConstants.setForeground(attrset1, new Color(96, 96, 96));
				textPane.setCaretPosition(textPane.getDocument().getLength());				
				textPane.getDocument().insertString(textPane.getDocument().getLength(), "我 "
				+CatUtil.getTimer()+":  ", attrset);
				textPane.getDocument().insertString(textPane.getDocument().getLength(),textPane_1.getText()+"\r\n\r\n", attrset1);
				textPane_1.setText("");
				
				textPane.getDocument().insertString(textPane.getDocument().getLength(), "小助手 "
				+CatUtil.getTimer()+":  ", attrset);
				textPane.getDocument().insertString(textPane.getDocument().getLength(), info+"\r\n\r\n", attrset1);
				textPane_1.requestFocus();
								
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
