package cat.server;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyCellRenderer extends JLabel implements ListCellRenderer{
	public MyCellRenderer() {
		this.setOpaque(true);
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		if(value!=null){
			setText(value.toString());		
			ImageIcon img=new ImageIcon("images//touxiang.jpg");
			img.setImage(img.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
			setIcon(img);
		}
		if(isSelected){
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}else{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		return this;
	}	
}
