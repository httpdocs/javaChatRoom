package cat.client;
import   java.awt.*; 
import   javax.swing.*;

import   java.awt.event.*; 

public   class   PicsJWindow  extends   JWindow   { 
	GridLayout   gridLayout1   =   new   GridLayout(7,15); 
	 MyLabel[]   ico=new   MyLabel[105]; /*放表情*/
    int  i;
    CatChatroom   owner;
    public   PicsJWindow(CatChatroom   owner)   { 
        super(owner); 
        this.owner=owner; 
        try   { 
            init(); 
            this.setAlwaysOnTop(true); 
        } 
        catch   (Exception   exception)   { 
            exception.printStackTrace(); 
        } 
    } 
    private   void   init()   throws   Exception   { 
		this.setPreferredSize(new Dimension(28*15,28*7));
		JPanel p = new JPanel();
		p.setOpaque(true);
		this.setContentPane(p);
    	p.setLayout(gridLayout1);
        p.setBackground(SystemColor.text);		
		String fileName ;
        for(i=0;i <ico.length;i++){ 
            fileName="src/cat/qqdefaultface/"+i+".gif";
            ico[i] =new  MyLabel(new ImageIcon(fileName));
            
            ico[i].setPath(fileName);
            
            ico[i].setBorder(BorderFactory.createLineBorder(new Color(225,225,225), 1));
            
            ico[i].setToolTipText(i+""); 
            
            ico[i].addMouseListener(new MouseAdapter() {
                public   void   mouseClicked(MouseEvent  e){ 
                	if(e.getButton()==1){
                		 MyLabel cubl = ( MyLabel)(e.getSource());
                		owner.insertImage(cubl);
                		cubl.setBorder(BorderFactory.createLineBorder(new Color(225,225,225), 1));
                    	getObj().dispose();
                	}
                }
				@Override
				public void mouseEntered(MouseEvent e) {
		            ((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLUE));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(new Color(225,225,225), 1));
				} 
                
			});
            
            p.add(ico[i]); 
        } 
    } 
    
	@Override
	public void setVisible(boolean show) {
		if (show) {
			determineAndSetLocation();
		}
		super.setVisible(show);
	}	
	private void determineAndSetLocation() {
		Point loc = owner.getBtn().getLocationOnScreen();/*控件相对于屏幕的位置*/
		setBounds(loc.x-getPreferredSize().width/3, loc.y-getPreferredSize().height,
				getPreferredSize().width, getPreferredSize().height);
	}
    private   JWindow   getObj(){ 
        return   this; 
    } 

} 

class MyLabel extends JLabel{
	public MyLabel(ImageIcon icon) {
		setIcon(icon);
	}
	private String path ;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}