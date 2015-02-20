package es.open4job.javase.jpa;

import javax.persistence.EntityManager;

public class App {
	public static void main(String[] args) {
		Territorio territorio = new Territorio();
		territorio.setCodigo("9999");
		territorio.setDescripcion("Prueba JPA");

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(territorio) ? territorio : em.merge(territorio));
		//em.persist(territorio);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
