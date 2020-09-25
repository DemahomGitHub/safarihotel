package com.safarihotel.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class Reservation {
    private Long id;

    @NotEmpty(message = "Le prénom est obligatoire")
    @NotBlank(message = "Format de prénom invalide")
    @Pattern(regexp = "((?=[A-Za-z])(?![_\\-]).)*$", message = "Le prénom contient des caractères non autorisés")
    private String firstName;

    @NotEmpty(message = "Le nom est obligatoire")
    @NotBlank(message = "Format de nom invalide")
    @Pattern(regexp = "((?=[A-Za-z])(?![_\\-]).)*$", message = "Le nom contient des caractères non autorisés")
    private String lastName;

    @NotEmpty(message = "Email obligatoire")
    @Email(message = "Email invalide")
    private String email;
}
