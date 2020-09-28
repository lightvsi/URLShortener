package ru.lightvsi.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lightvsi.urlshortener.model.URLPairModel;
import ru.lightvsi.urlshortener.service.URLPairService;
import ru.lightvsi.urlshortener.service.exception.BadRequest;
import ru.lightvsi.urlshortener.service.exception.LinkNotFound;

import java.net.URI;

@RestController
public class Controller {
    @Autowired
    private URLPairService urlPairService;

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<String> getShortURL(@RequestBody URLPairModel model) {
        try {
            return new ResponseEntity<>(urlPairService.put(model), HttpStatus.OK);
        } catch (BadRequest e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<HttpHeaders> getLongURL(@PathVariable String name) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(urlPairService.get(name)));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        } catch (LinkNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
