package cat.util;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.color.ColorSpace;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import com.jhlabs.image.BlockFilter;
import com.jhlabs.image.CircleFilter;
import com.jhlabs.image.EdgeFilter;
import com.jhlabs.image.EmbossFilter;
import com.jhlabs.image.InvertFilter;
import com.jhlabs.image.KaleidoscopeFilter;
import com.jhlabs.image.PerspectiveFilter;
import com.jhlabs.image.StampFilter;
import com.jhlabs.image.SwimFilter;
import com.jhlabs.image.TileImageFilter;
import com.jhlabs.image.TwirlFilter;
import com.jhlabs.image.WaterFilter;

import cat.client.CatChatroom;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class Xiu extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel label;
	public static	BufferedImage wbufferedImage = null;
	public static 	BufferedImage bufferedImage2 =null;
	private  CatChatroom catChatroom;
	public Xiu(BufferedImage image,CatChatroom catChatroom) {
		
		setVisible(true);
		wbufferedImage = image;
		this.catChatroom=catChatroom;
//		this.jTextPane=jtextpane;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/heibai.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					@Override
					public void run() {	
						 bufferedImage2 = new BufferedImage(
								wbufferedImage.getWidth(null),
									wbufferedImage.getHeight(null),  BufferedImage.TYPE_BYTE_GRAY);					
						//重点是后面参数 BufferedImage.TYPE_BYTE_BINARY就是二值图了	                                
						for(int i= 0 ; i < wbufferedImage.getWidth(null) ; i++){  
							for(int j = 0 ; j < wbufferedImage.getHeight(null); j++){  
								int rgb = wbufferedImage.getRGB(i, j);  //wbufferedImage是原来的那张图
								bufferedImage2.setRGB(i, j, rgb);
							}  
						} 
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						} 
						label.setIcon(new ImageIcon(bufferedImage2));
					}
				}.start();
			}
		});
		toolBar.add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/fanzhuan.jpg")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					@Override
					public void run() {						
						
					
						InvertFilter invertFilter=new InvertFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();

			}
		});
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/wanhuatong.jpg")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					@Override
					public void run() {						
						
						
						KaleidoscopeFilter kale =new KaleidoscopeFilter();
						bufferedImage2=kale.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(button_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/duochong.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					@Override
					public void run() {						
						TileImageFilter tile =new TileImageFilter();
						bufferedImage2=tile.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/toushi.jpg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				 PerspectiveFilter  
				new Thread(){
					@Override
					public void run() {						
						
						PerspectiveFilter invertFilter=new PerspectiveFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();

			}
		});
		toolBar.add(btnNewButton_1);
		
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/shuixia.jpg")));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				SwimFilter
				new Thread(){
					@Override
					public void run() {						
						
						SwimFilter invertFilter=new SwimFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton_11);
		
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/niuqu.jpg")));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TwirlFilter
				new Thread(){
					@Override
					public void run() {						
						
						TwirlFilter invertFilter=new TwirlFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton_12);
		
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/masaike.jpg")));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				BlockFilter
				new Thread(){
					@Override
					public void run() {						
						
						BlockFilter invertFilter=new BlockFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton_13);
		
		
		JButton btnNewButton_14 = new JButton("");
		btnNewButton_14.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/yahua.jpg")));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				EmbossFilter
				new Thread(){
					@Override
					public void run() {						
						
						EmbossFilter invertFilter=new EmbossFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton_14);
		
		
		JButton btnNewButton_15 = new JButton("");
		btnNewButton_15.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/tuzhang.jpg")));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				StampFilter
				new Thread(){
					@Override
					public void run() {						
						StampFilter invertFilter=new StampFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(btnNewButton_15);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Xiu.class.getResource("/cat/anniu/bianyuan.jpg")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				EdgeFilter
				new Thread(){
					@Override
					public void run() {						
						EdgeFilter invertFilter=new EdgeFilter();
						bufferedImage2=invertFilter.filter(wbufferedImage, bufferedImage2);						
						try {
							SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
							String fileName =sdf.format(new Date());
							ImageIO.write(bufferedImage2, "JPEG", new File("ScreenCut/"+fileName+"xiu.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}  
						System.out.println(bufferedImage2.toString());

						label.setIcon(new ImageIcon(bufferedImage2));
					
					}
				}.start();
			}
		});
		toolBar.add(button_3);

		label = new JLabel("");
		label.setIcon(new ImageIcon(image));
		contentPane.add(label, BorderLayout.CENTER);
		
		JButton button_4 = new JButton("确定");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new Thread(){
					@Override
					public void run() {					
						catChatroom.getSsw().setSaveImage(getimage());
						try {
							catChatroom.getSsw().getSubOpWindows().InsertImage();
							bufferedImage2=null;
						} catch (BadLocationException e) {
							e.printStackTrace();
						}
						Xiu.this.dispose();
					}
				}.start();
			}
		});
		contentPane.add(button_4, BorderLayout.SOUTH);
	}

	public static BufferedImage  getimage() {
		if(bufferedImage2==null){
			return  wbufferedImage;
		}
		 return bufferedImage2;
	}
	
	
}
