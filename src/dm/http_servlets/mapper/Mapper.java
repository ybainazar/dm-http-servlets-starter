package dm.http_servlets.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
