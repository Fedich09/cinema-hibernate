package com.dev.cinema.service.mapper;

public interface GenericMapper<I, T, R> {
    I toDto(R object);

    R toEntity(T object);
}
