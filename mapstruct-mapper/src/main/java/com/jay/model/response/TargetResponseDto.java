package com.jay.model.response;

import lombok.Builder;

@Builder
public record TargetResponseDto(

    String name,

    String description,

    int computedField,

    AddressResponse address
) {

}
