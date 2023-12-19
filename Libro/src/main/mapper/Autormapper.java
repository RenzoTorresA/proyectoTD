import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MiMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "edad", target = "age")
    MiDTO entidadAMiDTO(Entidad entidad);


    MiMapper INSTANCE = Mappers.getMapper(MiMapper.class);
}