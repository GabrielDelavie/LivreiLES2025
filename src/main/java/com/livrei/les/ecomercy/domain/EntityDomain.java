package com.livrei.les.ecomercy.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class EntityDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant registerDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant updateDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Instant registerDate) {
		this.registerDate = registerDate;
	}
	public Instant getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}
	
	public EntityDomain() {}
	
	public EntityDomain(Long id) {
		this.id = id;
	}
	
	@PrePersist
    protected void aoCriar() {
        this.registerDate = Instant.now();
        this.updateDate = Instant.now();
    }

    @PreUpdate
    protected void aoAtualizar() {
        this.updateDate = Instant.now();
    }
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityDomain other = (EntityDomain) obj;
		return Objects.equals(id, other.id);
	}

    
}
