package com.dev.operaapp.service.mapper.genericmapper;

public interface GenericMapperResponse<T, V> {
    T toDto(V entity);
}
