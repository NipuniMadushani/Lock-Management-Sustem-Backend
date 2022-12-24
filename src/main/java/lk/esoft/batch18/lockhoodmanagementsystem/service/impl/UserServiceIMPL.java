package lk.esoft.batch18.lockhoodmanagementsystem.service.impl;

import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated.PaginatedUsers;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.UserRepository;
import lk.esoft.batch18.lockhoodmanagementsystem.service.UserService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PaginatedUsers getAllUsers(int page, int size) {
        Page<User> users = userRepository.findAll(PageRequest.of(page,size));
        if(users.getSize()<1){
            throw new NotFoundException("no users currently available");
        }
        return new PaginatedUsers(
                userMapper.pageToList(users),
                userRepository.countAllBy()
        );
    }
}
