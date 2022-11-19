package flix.processor.report.dto;

import lombok.Getter;
import lombok.Setter;

public class ReportDto {
    @Getter
    @Setter
    public String data;

    @Getter
    @Setter
    public String source;

    @Getter
    @Setter
    public String tier;

    @Getter
    @Setter
    private String Name = "";

    @Getter
    @Setter
    private String Email = "";
}
