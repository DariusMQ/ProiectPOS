package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");
        try{
            TypedQuery<User> typedQuery = entityManager.createQuery("Select u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> users){
        List<UserDto> result = new ArrayList<>();
        for(User u: users){
            UserDto udto = new UserDto(u.getId(),u.getUsername(),u.getEmail(),u.getPassword(),u.getCart_id());
            result.add(udto);
        }
        return result;
    }
}
