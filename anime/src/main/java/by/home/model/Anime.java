package by.home.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alek on 31.12.17.
 */
@Data
public class Anime {

    @Getter @Setter
    private String nameEng;

    @Getter @Setter
    private String nameRus;

    @Getter @Setter
    private String nameJap;

}
