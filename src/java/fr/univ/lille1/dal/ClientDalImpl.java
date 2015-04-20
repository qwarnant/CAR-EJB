package fr.univ.lille1.dal;

import fr.univ.lille1.entities.Client;
import fr.univ.lille1.exception.NoUserExistException;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Cette classe est l'implémentation concrète de l'interface ClientDal
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
@Remote(ClientDal.class)
@Stateful
public class ClientDalImpl implements ClientDal {

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager em;

    @Override
    public boolean init() throws Exception {
        boolean retour = false;
        //admin
        retour = addUser("quentin1", "password1");
        if(!retour) return false;
        setAdmin("quent1");
        
        
        //user
        addUser("quentin2", "password2");

        return true;
    }

    @Override
    public List<Client> getUsers() throws Exception {
        Query q = em.createNamedQuery("allusers");
        List<Client> users = (List<Client>) q.getResultList();
        return users;
    }

    @Override
    public Client getUserByUsername(String username) throws Exception {
        Query q = em.createNamedQuery("findByUsername");
        q.setParameter("username", username);
        try {
            return (Client) q.getSingleResult();
        } catch (NoResultException e) {
            throw new NoUserExistException();
        }
    }

    @Override
    public boolean addUser(String username, String password) throws Exception {
        Client user = null;
        try {
            user = getUserByUsername(username);
            return false;
        } catch (NoUserExistException e) {
            // S'il n'existe pas d'utilisateur alors on l'ajoute
            user = new Client(username, password);
            em.persist(user);
            return true;
        }

    }

    @Override
    public boolean setAdmin(String username) throws Exception {
        try {
            Client user = getUserByUsername(username);
            user.setAdmin(true);
            em.persist(user);
            return true;
        } catch (NoUserExistException e) {
            return false;
        }

    }

}
