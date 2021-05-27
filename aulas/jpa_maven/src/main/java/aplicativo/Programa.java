package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	private static void insert_example() {
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!!!");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		em.close();
		emf.close();

	}

	private static void select_example() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		System.out.println("Pronto!!!");

		em.close();
		emf.close();
	}

	private static void delete_example() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		
		Pessoa p = em.find(Pessoa.class, 2);
		if (p != null)
		{
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}
		System.out.println("Pronto!!!");

		em.close();
		emf.close();
	}

	public static void main(String[] args) {

		
	}

}
