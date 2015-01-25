package com.example.jeedemo.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class MessageStorageService {
    @PersistenceContext
    EntityManager em;

    public Game get(Long id) {
        return em.find(Game.class, id);
    }

    public void add(Game message) {
        message.setId(null);

        em.persist(message);
    }

    public void update(Long id, String title, String message) {
    	Game msg = em.find(Game.class, id);
        msg.setMake(title);
        msg.setModel(message);

        em.merge(msg);
    }

    public void delete(Long id) {
    	Game message = em.find(Game.class, id);
        em.remove(message);
    }

    public List<Person> getAllMessages(){
        //noinspection unchecked
        return em.createNamedQuery("person.all").getResultList();
    }

    public List<Game> getMessages(int offset, int limit){
        //noinspection unchecked
        return em.createNamedQuery("message.all").
                setFirstResult(offset).
                setMaxResults(limit).
                getResultList();
    }

    public Long getCount() {
        return (Long) em.createQuery("select count(m) from Message m").getSingleResult();
    }

    public List<Game> getAllByAuthor(String author) {
        //noinspection unchecked
        return em.createQuery("select m from Message m where m.author = :author").
                setParameter("author", author).getResultList();
    }
}