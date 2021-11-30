package br.com.enterprise.pocuserservice.resolvers;

import br.com.enterprise.pocuserservice.inputs.UserInput;
import br.com.enterprise.pocuserservice.models.User;
import br.com.enterprise.pocuserservice.repositories.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserInput userInput){
        User user = new User();

        user.setName(userInput.getName());
        user.setCpf(userInput.getCpf());

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserInput userInput){
        User userFound = userRepository.findById(id).orElse(null);

        if(userFound == null) return null;

        User user = new User();
        user.setId(id);
        user.setName(userInput.getName());
        user.setCpf(userInput.getCpf());

        return userRepository.save(user);
    }

    public String deleteUser(Long id){

        User user = userRepository.findById(id).orElse(null);

        if(user == null) return "Usuário não encontrado na base de dados";

        userRepository.delete(user);

        return "Usuário removido com sucesso";

    }

}
