package com.agencyBack.service.impl;

import com.agencyBack.entity.Base;
import com.agencyBack.repository.BaseRepository;
import com.agencyBack.service.BaseService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends Base> implements BaseService <T>{

    private BaseRepository<T> repository;

    private T baseObject;

    private static ModelMapper modelMapper;

    public <B extends BaseRepository<T>> BaseServiceImpl(B repository, T baseObject) {
        this.repository = repository;
        this.baseObject = baseObject;
    }

// ----- Public Functions -----

    @Override
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public T getById(Long id) throws NotFoundException {
        Optional<T> base = repository.findById(id);
        if (!base.isPresent())
            throw new NotFoundException(baseObject.getClass().getName().substring((baseObject.getClass().getName().lastIndexOf("."))).substring(1) + " not found with id: " + id);
        return base.get();
    }

    @Override
    public T create(T base) {
//        if (base == null)
//            throw new NotWellFormedException("Missing information required for " + baseObject.getClassName() + " creation.");
        return repository.save(base);
    }

    @Override
    public T edit(T base) throws NotFoundException {
        return edit(base, null);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        this.repository.deleteById(id);
    }


    protected T edit(T newBase, T oldBase) throws NotFoundException {
        if (oldBase == null)
            oldBase = getById(newBase.getId());
        //Sets all the attributes for a given object
        modelMapper.map(newBase, oldBase);
        return repository.save(oldBase);
    }
}
