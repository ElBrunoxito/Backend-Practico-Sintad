package com.yobrunox.backendsintad.dto.entidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntidadCreateDTO {
    @NotBlank(message = "El número de documento no puede estar vacío")
    @Size(max = 20, message = "El número de documento no puede exceder los 20 caracteres")
    private String nroDocumento;

    @NotBlank(message = "La razón social no puede estar vacía")
    @Size(max = 50, message = "La razón social no puede exceder los 50 caracteres")
    private String razonSocial;

    @NotBlank(message = "El nombre comercial no puede estar vacío")
    @Size(max = 100, message = "El nombre comercial no puede exceder los 100 caracteres")
    private String nombreComercial;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    private String direccion;

    @Size(max = 30, message = "El teléfono no puede exceder los 30 caracteres")
    private String telefono;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;

    private Integer idTipoDocumento;
    private Integer idTipoContribuyente;

}
