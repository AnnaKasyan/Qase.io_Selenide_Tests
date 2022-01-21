package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseResponseBody <T>{
    boolean status;
    T result;
}
