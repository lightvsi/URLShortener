package ru.lightvsi.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightvsi.urlshortener.entity.URLPair;
import ru.lightvsi.urlshortener.model.URLPairModel;
import ru.lightvsi.urlshortener.repository.URLPairRepository;
import ru.lightvsi.urlshortener.service.exception.BadRequest;
import ru.lightvsi.urlshortener.service.exception.LinkNotFound;

@Service
public class URLPairService {
    @Autowired
    private URLPairRepository urlPairRepository;
    @Autowired
    private GeneratorService generatorService;
    @Autowired
    private ValidatorService validatorService;
    private final String address = "http://localhost:8080/";

    @Transactional
    public String put(URLPairModel model) throws BadRequest {
        int op = validatorService.validateModel(model);
        switch (op) {
            case 1:
                if (urlPairRepository.existsByLurl(model.getUrl())) {
                    return address + urlPairRepository.findByLurl(model.getUrl()).get().getSurl();
                } else {
                    String generated = generatorService.generate();
                    while (urlPairRepository.existsBySurl(generated)) {
                        generated = generatorService.generate();
                    }
                    urlPairRepository.save(new URLPair(generated, model.getUrl()));
                    return address + generated;
                }
            case 2:
                if (urlPairRepository.existsBySurl(model.getName())) {
                    throw new BadRequest();
                } else {
                    urlPairRepository.save(new URLPair(model.getName(), model.getUrl()));
                    return address + model.getName();
                }
            default:
                throw new BadRequest();
        }
    }


    @Transactional
    public String get(String surl) throws LinkNotFound {
        return urlPairRepository.findBySurl(surl).orElseThrow(LinkNotFound::new).getLurl();
    }
}
