package com.example.cs564.entity;

import com.example.cs564.entity.key.IncludesKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(IncludesKey.class)
@Table(name = "include")
@Data
public class IncludesEntity {
    @Id
    private String spotify_uri;
    @Id
    private Long pid;
}
