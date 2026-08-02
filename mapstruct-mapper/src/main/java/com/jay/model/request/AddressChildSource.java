package com.jay.model.request;

import lombok.Builder;

@Builder
public record AddressChildSource(

    String userState,

    String zipCode
) {

}
