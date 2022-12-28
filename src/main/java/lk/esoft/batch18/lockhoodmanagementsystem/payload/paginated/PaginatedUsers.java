package lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedUsers {
    private List<SignupRequest> list;
    private long dataCount;
}
