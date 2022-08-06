package com.jay.mapper;

import com.jay.model.Destination;
import com.jay.model.Origin;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SourceToDestinationMapper {

  //This also works
  @Mapping(target = "name", source = "origin.originName")
  @Mapping(target = "description", source = "originDescription")
  Destination toDestination(Origin origin);

  @AfterMapping
  default void mapNow() {
    System.out.println("Inside after mapping");
  }
}
