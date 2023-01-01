package lk.esoft.batch18.lockhoodmanagementsystem.util.mappers;
import lk.esoft.batch18.lockhoodmanagementsystem.dto.KanBanDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.KanBanCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KanBanMapper {
    KanBanCard requestDtoToEntity(KanBanDTO kanBanDTO);
}
