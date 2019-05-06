package com.equant.practice.mapper;

        import com.equant.practice.dto.user.UserDTOForGet;
        import com.equant.practice.dto.user.WrapperForUserDTO;

        import java.util.List;

/**
 * Фасад для преобразования между можелями БД и фронта
 */

public interface MapperFacade {


    <S, D> D map(S sourceObject, Class<D> destinationClass);


    <S, D> void map(S sourceObject, D destinationObject);

    <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);

    UserDTOForGet mapWrapper(WrapperForUserDTO wrapperForUserDTO);

}
