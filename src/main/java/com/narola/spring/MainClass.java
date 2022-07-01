package com.narola.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

//            for (int i = 1; i <= 10; i++) {
//                Post post = new Post();
//                post.setPostTitle("XYZ" + i);
//                post.setPostDesc("TEST" + i);
//
//                List<PostComment> postComments = new ArrayList<>();
//                PostComment postComment1 = new PostComment();
//                postComment1.setComment("comment...." + i);
//                postComment1.setPost(post);
//                postComments.add(postComment1);
//
//                PostComment postComment2 = new PostComment();
//                postComment2.setComment("comment...." + i);
//                postComment2.setPost(post);
//                postComments.add(postComment2);
//
//                post.setCommentList(postComments);
//
//                entityManager.persist(post);
//            }


//            entityManager.merge(post);
////            entityManager.remove(post);
////            entityManager.detach(post);

            Post post1 = entityManager.find(Post.class, 11L);
//            System.out.println(post1.getCommentList());
            post1.getCommentList().remove(0);
//            System.out.println(post1);
            entityManager.persist(post1);


            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static void test1(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User();
        user.setFirstName("JAVA");
        user.setLastName("8");
        user.setEmail("java1@narola.com");
        user.setCreatedOn(new Date());

        List<Address> addresses = new ArrayList<>();
        Address address1 = new Address();
        address1.setAddress("Surat");
//        address1.setUser(user);

        addresses.add(address1);

        user.setAddresses(addresses);

        entityManager.persist(user);
        transaction.commit();
    }

    public static void test2(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = new User();
        user.setFirstName("JAVA");
        user.setLastName("8");
        user.setEmail("java1@narola.com");
        user.setCreatedOn(new Date());

//        Address address1 = new Address();
//        address1.setAddress("Surat");
//        address1.setUser(user);

//        entityManager.persist(address1);
        transaction.commit();
    }
}
