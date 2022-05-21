package com.departamentoapi.demo.domain;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VotedOkDTO {
    private String confirmation;
    private String token;
}
