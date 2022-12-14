package flix.processor.ImageProcessor.Dto;


import flix.processor.ImageProcessor.entity.Data;
import lombok.Getter;
import lombok.Setter;

public class DataDto {

    public DataDto(Data dta) {
        setData(dta.getValue());
        setTier(dta.getTier());
        setSource(dta.getSource());
        setUserId(dta.getUserId());
    }

    public DataDto() {
    }

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
