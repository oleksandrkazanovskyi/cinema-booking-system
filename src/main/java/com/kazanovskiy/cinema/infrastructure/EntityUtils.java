package com.kazanovskiy.cinema.infrastructure;

import com.kazanovskiy.cinema.model.BaseEntity;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@UtilityClass
public class EntityUtils {

    public static <T extends BaseEntity> T safeGetEntity(T object, String msg) {
        return CommonUtils.safeGet(object, () -> new EntityNotFoundException(msg));
    }

    public static <T extends BaseEntity> List<T> safeGetEntityCollection(List<T> entityCollection, String msg) {
        return CommonUtils.safeGet(entityCollection, () -> new EntityNotFoundException(msg));
    }

    public static <T extends BaseEntity> T safeGetEntity(T object) {
        return safeGetEntity(object, "Entity not found");
    }

    public static <T extends BaseEntity> List<T> safeGetEntityCollection(List<T> entityCollection) {
        return safeGetEntityCollection(entityCollection, "Entities collection is empty");
    }

    public static <T extends BaseEntity> T getDummyEntityById(Long id, Class<T> entityClass) {
        T entity;

        try {
            entity = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        entity.setId(id);
        return entity;
    }
}
