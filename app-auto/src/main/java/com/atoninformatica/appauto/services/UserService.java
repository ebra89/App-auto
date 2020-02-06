package com.atoninformatica.appauto.services;

import com.atoninformatica.appauto.entities.Role;
import com.atoninformatica.appauto.entities.User;
import com.atoninformatica.appauto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role>roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role>roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public List<User>userList(){
        return userRepository.findAll();
    }

    public List<User>findByName(String nome){
        return userRepository.findByNomeLike("%"+nome+"%");
    }

    public void deleteUser(String email){
        User u = userRepository.findByEmail(email);
        userRepository.delete(u);
    }

    public boolean userPresente(String email){
        User u = userRepository.findByEmail(email);
        if(u != null){
            return true;
        }
        return false;
    }

    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }
}
