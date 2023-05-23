package org.orinaldaramg.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class CodeValue {
    @Id
    private String code;

    @Lob
    private String value;
}
