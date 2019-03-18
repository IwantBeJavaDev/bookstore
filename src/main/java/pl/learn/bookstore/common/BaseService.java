package pl.learn.bookstore.common;

public interface BaseService<T extends AbstractDto> {
    T saveOrUpdate(T dto);

    void delete(T dto);

    T find(Long id);
}
