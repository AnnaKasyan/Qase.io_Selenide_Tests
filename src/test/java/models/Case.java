package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    String code;
    String description;
    String preconditions;
    String postconditions;
    String title;
    int severity;
    int priority;
    int type;
    int id;
    int position;
}
