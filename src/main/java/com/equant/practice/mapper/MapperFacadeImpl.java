package com.equant.practice.mapper;


import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperFacadeImpl implements MapperFacade {

    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().map(sourceObject,destinationClass);
    }

    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
mapperFactory.getMapperFacade().map(sourceObject,destinationObject);
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().mapAsList(source,destinationClass);
    }
/*    public UserDTOLong mapWrapper (WrapperForUserDTO wrapperForUserDTO){
        UserDTOLong userDTOForGet = new UserDTOLong();
         mapperFactory.getMapperFacade().map(wrapperForUserDTO.getDocument(), userDTOForGet);
         mapperFactory.getMapperFacade().map(wrapperForUserDTO.getDocumentType(), userDTOForGet);
         mapperFactory.getMapperFacade().map(wrapperForUserDTO.getCountry(), userDTOForGet);
         *//*выполняется послеждним чтобы правильно заполнилось поле ID*//*
        mapperFactory.getMapperFacade().map(wrapperForUserDTO.getUser(), userDTOForGet);
        System.out.println(userDTOForGet);
         return userDTOForGet;

    }*/
}
