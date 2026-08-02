package com.jay.model.response;

import lombok.Builder;

@Builder
public record AddressResponse(
    String street,

    String city,

    AddressChildResponse addressChildResponse
) {

}
