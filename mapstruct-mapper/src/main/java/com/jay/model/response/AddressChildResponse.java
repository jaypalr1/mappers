package com.jay.model.response;

import lombok.Builder;

@Builder
public record AddressChildResponse(

    String state,

    String pinCode
) {

}
