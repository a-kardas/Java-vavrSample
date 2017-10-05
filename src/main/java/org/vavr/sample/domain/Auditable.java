package org.vavr.sample.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by aleksandra on 05.10.17.
 */
@Data
public abstract class Auditable {

    private LocalDateTime creation = LocalDateTime.now();
}
