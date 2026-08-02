package com.jay.mapper;

import com.jay.model.request.AddressSource;
import com.jay.model.request.Source;
import com.jay.model.response.AddressResponse;
import com.jay.model.response.TargetResponseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SourceToDestinationMapper {

  // Custom field mapping
  @Mapping(source = "originName", target = "name")
  @Mapping(source = "originDescription", target = "description")
  @Mapping(source = "computedField", target = "computedField", qualifiedByName = "calculateComputedField")
  TargetResponseDto toTargetResponse(Source source);

  // Option 1
  // @Mapping(source = "addressChildSource", target = "addressChildResponse")
  // AddressResponse toAddress(AddressSource address);

  // In case of Option 1, this mapping is needed for child class mapping
  // @Mapping(source = "userState", target = "state")
  // @Mapping(source = "zipCode", target = "pinCode")
  // AddressChildResponse toAddressChild(AddressChildSource addressChildSource);

  // OR

  // Option 2 - No need to map inner object as we're doing the mapping using @Mapping
  // Map AddressSource -> AddressResponse. Street and city have the same names so
  // MapStruct will map them automatically. For the nested child where names differ
  // we map the child properties into the nested AddressChildResponse fields.
  @Mapping(source = "addressChildSource.userState", target = "addressChildResponse.state")
  @Mapping(source = "addressChildSource.zipCode", target = "addressChildResponse.pinCode")
  AddressResponse toAddress(AddressSource address);

  @Named("calculateComputedField")
  default int calculateComputedFieldCustomName(int input) {
    return input * 7;
  }

  // Quick hack to check mapping after everything is done
  @AfterMapping
  default void mapNow(Source source, @MappingTarget TargetResponseDto targetResponseDto) {
    System.out.println("Inside after mapping");
  }
}
