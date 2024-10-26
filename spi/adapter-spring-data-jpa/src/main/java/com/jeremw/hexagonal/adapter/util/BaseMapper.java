package com.jeremw.hexagonal.adapter.util;

import java.util.List;
import java.util.Optional;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
public interface BaseMapper<M, E> {

    M toModel(E entity);

    List<M> toModelList(List<E> entities);

    E toEntity(M model);

    List<E> toEntityList(List<M> models);
}

