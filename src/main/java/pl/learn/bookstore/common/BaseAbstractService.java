package pl.learn.bookstore.common;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseAbstractService<T extends AbstractDto, E extends AbstractEntity> {

    private E entity;
    private ModelMapper modelMapper;

    public BaseAbstractService() {
        this.modelMapper = new ModelMapper();
    }

    private void createEntityClass(Class<E> clazz)  {
        try {
            this.entity = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected   <T,E> void assignDtoToEntity(T dto, E entity){
        modelMapper.map(dto,entity);
    }

    protected  E createAndAssignEntityByDto(T dto, Class<E> entityClass){
       createEntityClass(entityClass);
        assignDtoToEntity(dto, this.entity);
        return this.entity;
    }

    protected void assignEntityToDto(E entity, T dto) {
        modelMapper.map(entity, dto);
    }
}
