package ru.lightvsi.urlshortener.entity;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class URLPair {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String surl;

    @Column(columnDefinition = "LONGTEXT")
    String lurl;

    public URLPair() {
    }

    public URLPair(String surl, String lurl) {
        this.surl = surl;
        this.lurl = lurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getLurl() {
        return lurl;
    }

    public void setLurl(String lurl) {
        this.lurl = lurl;
    }
}
