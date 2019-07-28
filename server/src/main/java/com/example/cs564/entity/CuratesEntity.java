package com.example.cs564.entity;

import com.example.cs564.entity.key.ArtistKey;
import com.example.cs564.entity.key.CuratesKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CuratesKey.class)
@Table(name = "curates")
@Data
public class CuratesEntity {
    @Id
    private Long uid;
    @Id
    private Long pid;
}
