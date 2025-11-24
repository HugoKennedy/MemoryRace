package tsp.pro3600.memoryrace.interfaceswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

import tsp.pro3600.memoryrace.connectionmodel.*;


public class FenetrePrincipale extends JFrame {
	
	/**
	 * Wrapper class for CouseData to add a toString function for use inside JComboBox
	 * @version 0.1
	 */
	private class CourseItem {
		
		CourseData course;
		
		public CourseItem(CourseData course)
		{
			this.course = course;
		}
		
		public String toString()
		{
			return this.course.getName();
		}
		
		public CourseData getCourse()
		{
			return this.course;
		}
		
	}

    private JButton bouton = new JButton("Trouver mes photos");
    private JPanel conteneur = new JPanel();
    private JTextField texte = new JTextField("N° Dossard");
    private JComboBox<CourseItem> combo = new JComboBox<>();
    private ConnectionHandler conn;
    private RequestFactory reqFactory;

    public FenetrePrincipale(ConnectionHandler conn) throws ConnectionErrorException {
    	this.conn = conn;
    	this.reqFactory = conn.createRequestFactory();
    	
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MemoryRace");
        setResizable(false);

        // ajout listerner sur le bouton
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseItem event = (CourseItem) combo.getSelectedItem();
                String dossard = texte.getText().trim();
                
                PhotoWithDossardRequest reqPhotos = FenetrePrincipale.this.reqFactory.createPhotoWithDossardRequest(Integer.parseInt(dossard), event.getCourse());
                FenetrePrincipale.this.conn.setRequest(reqPhotos);
                try {
                FenetrePrincipale.this.conn.execute();
                }
                catch (Exception ee)
                {
                	ee.printStackTrace();
                	System.out.println(ee.getMessage());
                }
                PhotoListResponse resPhotos = (PhotoListResponse)FenetrePrincipale.this.conn.getResponse();
                FenetrePhotos fenPhotos = new FenetrePhotos(resPhotos.getPhotoList());
            }
        });

        //ajout du gestionnaire de composants BoxLayout
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.PAGE_AXIS));

        //ajout d'éléments dans la combobox
        CourseListRequest reqCourseList = this.reqFactory.createCourseListRequest();
        conn.setRequest(reqCourseList);
        conn.execute();
        CourseListResponse resCourseList = (CourseListResponse)conn.getResponse();
        for (CourseData course : resCourseList.getCourseList())
        {
        	combo.addItem(new CourseItem(course));
        }


        //ajout combobox
        conteneur.add(combo);
        setContentPane(conteneur);

        //ajout texte n°dossard
        conteneur.add(texte);
        setContentPane(conteneur);

        //ajout du bouton "Trouver photos"
        conteneur.add(bouton);
        setContentPane(conteneur);

        pack();
    }
}
