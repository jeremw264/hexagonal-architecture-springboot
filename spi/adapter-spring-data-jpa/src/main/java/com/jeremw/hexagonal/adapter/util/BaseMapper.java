package com.jeremw.hexagonal.adapter.util;

import java.util.List;

/**
 * Generic interface for mapping between domain models and data entities.
 *
 * @param <M> the type of the domain model
 * @param <E> the type of the data entity
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
public interface BaseMapper<M, E> {

    /**
     * Converts a data entity to its corresponding domain model.
     *
     * @param entity the data entity to convert
     * @return the corresponding domain model
     */
    M toModel(E entity);

    /**
     * Converts a list of data entities to a list of corresponding domain models.
     *
     * @param entities the list of data entities to convert
     * @return a list of corresponding domain models
     */
    List<M> toModelList(List<E> entities);

    /**
     * Converts a domain model to its corresponding data entity.
     *
     * @param model the domain model to convert
     * @return the corresponding data entity
     */
    E toEntity(M model);

    /**
     * Converts a list of domain models to a list of corresponding data entities.
     *
     * @param models the list of domain models to convert
     * @return a list of corresponding data entities
     */
    List<E> toEntityList(List<M> models);
}

