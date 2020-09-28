package ru.lightvsi.urlshortener.service;

import org.springframework.stereotype.Service;
import ru.lightvsi.urlshortener.model.URLPairModel;
import ru.lightvsi.urlshortener.service.exception.BadRequest;

@Service
public class ValidatorService {
    public boolean validateUrl(String name) {
        return name.matches("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
    }

    public boolean validateName(String name) {
        return name.matches("[A-Za-z0-9-]+") && name.length() > 2 && name.length() < 31;
    }

    public int validateModel(URLPairModel model) throws BadRequest {
        if (model.getUrl() == null || !validateUrl(model.getUrl())) {
            throw new BadRequest();
        }
        if (model.getName() == null) {
            return 1;
        } else if (validateName(model.getName())) {
            return 2;
        } else {
            throw new BadRequest();
        }
    }
}
