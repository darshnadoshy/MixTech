package com.example.cs564.entity;

import com.example.cs564.entity.key.ArtistKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * artist table
 */

@Entity
@IdClass(ArtistKey.class)
@Table(name = "artist")
@Data
public class ArtistEntity {
	@Id
	private String aname;
	@Id
	private String spotify_uri;
}
