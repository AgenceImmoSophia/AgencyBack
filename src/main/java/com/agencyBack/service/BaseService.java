package com.agencyBack.service;

import java.util.List;

public interface BaseService<T> {
    /**
     * Gets all objects that are active and not removed from a certain type.
     * The type must be a child of Base.
     * @return A list of objects of this type.
     */
    List<T> getAll();

    /**
     * Gets an object of a type by it's id.
     * The type must be a child of Base.
     * @param id Object's id
     * @return the object found or throws a NotFoundException
     */
    T getById(Long id);

    /**
     * Method that created an object.
     * The object must be a child of Base.
     * @param base the object to be created
     * @return the created object.
     */
    T create(T base);

    /**
     * Method that updates an object.
     * The object must be a child of Base.
     * @param base the object to be updated
     * @return the updated object.
     */
    T edit(T base);

    /**
     * Method that deletes an object by it's id.
     * The object must be a child of Base.
     * @param id The id of the object to be deleted.
     */
    void deleteById(Long id);
}
