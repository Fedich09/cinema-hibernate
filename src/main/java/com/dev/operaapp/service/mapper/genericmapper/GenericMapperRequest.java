package com.dev.operaapp.service.mapper.genericmapper;

public interface GenericMapperRequest<T, V> {
    T toEntity(V requestDto);
}
