package br.senai.sc.tii2014n1.inovagames.connection;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

@ApplicationScoped
public class ConectionFactory {

	private static EntityManager manager;
    

    public static EntityManager getConnection() {
    	EntityManagerFactory emf = null;
        manager = null;
        emf = Persistence.createEntityManagerFactory("inovagamesTCC_PU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()) {
        	JOptionPane.showMessageDialog(null, "Conexão fechada");
        }
        return manager;
    }
}
