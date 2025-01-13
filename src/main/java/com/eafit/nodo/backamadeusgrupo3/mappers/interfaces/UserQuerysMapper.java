package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserQueryResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.UserQuerysEntity;
import com.eafit.nodo.backamadeusgrupo3.models.UserQuerysModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface UserQuerysMapper {
    @Mapping(target = "queryTime", source = "queryTime", qualifiedByName = "stringToTimestamp")
    UserQuerysEntity toUserQuerysEntity(UserQuerysModel userQuerysModel);

    @Mapping(target = "queryTime", source = "queryTime", qualifiedByName = "timestampToString")
    UserQuerysModel toUserQuerysModel(UserQuerysEntity userQuerysEntity);

    UserQueryResponse toUserQueryResponse(UserQuerysEntity userQuerysEntity);

    @Named("stringToTimestamp")
    default Timestamp stringToTimestamp(String value) {
        return value == null ? null : Timestamp.valueOf(value);
    }

    @Named("timestampToString")
    default String timestampToString(Timestamp value) {
        return value == null ? null : value.toString();
    }
}