package com.university.javaeeproject.mapper;
import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<Entity, Dto> {

    public abstract Entity toEntity(Dto dto);

    public abstract Dto toDto(Entity entity);

    public List<Entity> toEntity(List<Dto> dtoList) {
        List<Entity> entityList = new ArrayList<>();
        for (Dto dto : dtoList)
            entityList.add(toEntity(dto));

        return entityList;
    }

    public List<Dto> toDto(List<Entity> entityList) {
        List<Dto> dtoList = new ArrayList<>();
        for (Entity entity : entityList)
            dtoList.add(toDto(entity));

        return dtoList;
    }
}