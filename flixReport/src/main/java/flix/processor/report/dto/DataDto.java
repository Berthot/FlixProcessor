package flix.processor.report.dto;

import lombok.Getter;
import lombok.Setter;

public class DataDto {
    @Getter
    @Setter
    public String data;

    @Getter
    @Setter
    public String source;

    @Getter
    @Setter
    public int userId;

    @Getter
    @Setter
    public String tier;
}
