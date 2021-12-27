package models;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    private String title;
    private String description;
    private String pre_conditions;
    private String post_conditions;
    private String suite;
    private String severity;
    private String priority;
    private String type;

    public TestCase() {}

    public TestCase(String title, String description, String pre_conditions, String post_conditions, String suite, String severity, String priority, String type) {
        this.title = title;
        this.description = description;
        this.pre_conditions = pre_conditions;
        this.post_conditions = post_conditions;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
    }
}
