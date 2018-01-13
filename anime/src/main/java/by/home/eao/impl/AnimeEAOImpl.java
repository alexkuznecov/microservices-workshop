package by.home.eao.impl;

import by.home.eao.AnimeEAO;
import by.home.model.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author alek
 * @since 0.0.11
 */
public class AnimeEAOImpl implements AnimeEAO {

    @Autowired
    private MongoTemplate template;

    @Override
    public void insert(Anime anime) {
        template.insert(anime);
    }
}
