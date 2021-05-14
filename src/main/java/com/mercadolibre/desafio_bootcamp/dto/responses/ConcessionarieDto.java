package com.mercadolibre.desafio_bootcamp.dto.responses;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionarieDto {
    private Long id;
    @NotNull(message = "Field address can't be null")
    private String address;
    @NotNull(message = "Field name can't be null")
    private String name;
    @NotNull(message = "Field phone can't be null")
    private String phone;
    @NotNull(message = "Field country can't be null")
    private String country;
}
