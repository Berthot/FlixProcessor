package flix.processor.ImageProcessor.entity;

import flix.processor.ImageProcessor.Dto.DataDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Value;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Source;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Tier;

    @Getter
    @Setter
    @Column(nullable = false)
    private int UserId;


    public Data(DataDto data) {
        this.setValue(data.getData());
        this.setUserId(data.getUserId());
        this.setSource(data.getSource());
        this.GetTierValue(data.getData());
    }

    private void GetTierValue(String data) {
        var acc = 0;
        for (int i = 0; i < 2; i++) {
            var cha = data.charAt(i);
            acc += (Character.getNumericValue(cha) - 10);
        }

        if(acc <= 5)
            this.setTier("S");
        else if(acc <= 16)
            this.setTier("A");
        else if(acc <= 23)
            this.setTier("B");
        else if(acc <= 34)
            this.setTier("C");
        else if(acc <= 48)
            this.setTier("D");
        else if(acc <= 62)
            this.setTier("Z");
        else
            // should throw ex
            this.setTier("Trash");
    }

    public Data() {

    }
}
