package RepositoriesImpl;

import Entity.Temp;
import Repositories.TempRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Stateless
public class TempRepositoryImpl implements TempRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Temp temp;

    @Override
    public void addTemp(Temp temp){
        System.out.println("Temp about to be added");
        //temp.setId(1);
        temp.setName("Test");
        temp.setSurname("Test");
        temp.setAddress("temp@gmail.com");
        entityManager.persist(temp);
    }
}
