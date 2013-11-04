package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerUtils {
	private EntityManagerUtils() {}
	public static final String puName = "eLibraryPU";
	
	private static EntityManagerFactory emf; 

	public static EntityManager getEntityManager() {
		synchronized(EntityManagerUtils.class) {
			if (emf == null) 
				emf = Persistence.createEntityManagerFactory(puName);
		}
		return emf.createEntityManager();
	}
}
