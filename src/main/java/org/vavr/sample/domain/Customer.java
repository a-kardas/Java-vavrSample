package org.vavr.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by aleksandra on 04.10.17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Auditable {

    private String firstName;
    private String lastName;
    private String pesel;
}