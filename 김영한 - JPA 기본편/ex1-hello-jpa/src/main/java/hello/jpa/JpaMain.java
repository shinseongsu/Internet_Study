package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 추가
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//            
//            tx.commit();

//            조회
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // flush
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            // 영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");
//
//            //em.detach(member);  // 특정 영속성  -> 준 영속성으로 변경
//            em.clear();
//
//            Member member2 = em.find(Member.class, 100L);
//
//            System.out.println("============");

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("============");
            em.persist(member1);
            em.persist(member2);

            System.out.println("member => " + member1.getId());
            System.out.println("member => " + member2.getId());
            System.out.println("member => " + member3.getId());

            System.out.println("============");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
