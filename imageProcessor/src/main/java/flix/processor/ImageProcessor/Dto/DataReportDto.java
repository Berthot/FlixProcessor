package flix.processor.ImageProcessor.Dto;

import flix.processor.ImageProcessor.entity.Data;
import lombok.Getter;
import lombok.Setter;

public class DataReportDto {
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

    public DataReportDto(Data i) {
        setData(i.getValue());
        setTier(i.getTier());
        setUserId(i.getUserId());
        setSource(i.getSource());
    }

    public DataReportDto() {
    }
}
