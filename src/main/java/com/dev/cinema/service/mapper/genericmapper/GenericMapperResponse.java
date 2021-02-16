package com.dev.cinema.service.mapper.genericmapper;

public interface GenericMapperResponse<T, V> {
    T toDto(V entity);
}
