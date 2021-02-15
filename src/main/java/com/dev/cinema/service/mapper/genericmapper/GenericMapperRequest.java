package com.dev.cinema.service.mapper.genericmapper;

public interface GenericMapperRequest<T, V> {
    T toEntity(V object);
}
