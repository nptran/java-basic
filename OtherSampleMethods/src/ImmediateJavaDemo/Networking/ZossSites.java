package ImmediateJavaDemo.Networking;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ZossSites extends JApplet {
	
	private HashMap<String, URL> websiteInfo;
	private ArrayList<String> titles;
	private JList mainList;
	
	public void init() {
		websiteInfo = new HashMap<String, URL>();
		titles = new ArrayList<String>();
		
		grabHTMLInfo();
		add(new JLabel("What website do you want to visit?"), BorderLayout.NORTH);
		mainList = new JList(titles.toArray());
		
		mainList.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						Object obj = mainList.getSelectedValue();
						URL newDocument = websiteInfo.get(obj);
						AppletContext browser = getAppletContext();
						browser.showDocument(newDocument);
					}
				}
		);
		add(new JScrollPane(mainList), BorderLayout.CENTER);
	}
	
	//get website info
	private void grabHTMLInfo() {
		String title;
		String address;
		URL url;
		int counter = 0;
		title = getParameter("title" + counter);
		
		while(title != null) {
			address = getParameter("address" + counter);
			try {
				url = new URL(address);
				websiteInfo.put(title, url);
				titles.add(title);
			} catch(MalformedURLException e){
				e.printStackTrace();
			}
			++counter;
			title = getParameter("title"+counter);
		}
	}

}
