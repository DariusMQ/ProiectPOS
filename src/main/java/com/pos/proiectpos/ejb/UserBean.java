package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.entities.User;
import com.pos.proiectpos.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;
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
    public void createUser(String username, String email, String password, Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }

    }
    public Collection<String> findUsernamesByUserIDs(Collection<Long>userIds){
        List<String> usernames =
                entityManager.createQuery("SELECT U.username FROM User u WHERE u.id IN :userIds",String.class)
                        .setParameter("userIds",userIds)
                        .getResultList();
        return usernames;

    }
}
