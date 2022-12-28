package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<SignupRequest> pageToList(Page<User> items);
}
