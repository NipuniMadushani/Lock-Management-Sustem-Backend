package lk.esoft.batch18.lockhoodmanagementsystem.service;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetUserDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated.PaginatedUsers;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;

import java.util.List;

public interface UserService {

    PaginatedUsers getAllUsers(int page, int size);

    GetUserDTO getUserByIdActive(Long userId,boolean b);
}
