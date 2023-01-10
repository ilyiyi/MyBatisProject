package com.wak.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDomain {
    private String createName;
    private String updateName;
}
