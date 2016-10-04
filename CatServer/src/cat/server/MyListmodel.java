package cat.server;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import cat.function.CatClientBean;

class MyListmodel extends DefaultListModel{

	private Vector<CatClientBean>  clientBeans =null;
	
	public MyListmodel getModle() {
		return this;
	}
	
	@Override
	public Enumeration elements() {
		// TODO Auto-generated method stub
		return super.elements();
	}

	public MyListmodel(HashMap<String, CatClientBean> onlines) {
		clientBeans =new Vector<>();
		clientBeans = (Vector<CatClientBean>)onlines.values();
	}

	@Override
	public void addElement(Object element) {
		clientBeans.add((CatClientBean) element);
	}

	@Override
	public boolean removeElement(Object obj) {
		return 	clientBeans.remove(obj);
	}

	@Override
	public void clear() {
		clientBeans.removeAllElements();
	}

}
