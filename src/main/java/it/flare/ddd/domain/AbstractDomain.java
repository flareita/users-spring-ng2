package it.flare.ddd.domain;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.beans.BeanUtils;

@MappedSuperclass
public abstract class AbstractDomain<T, D> implements Serializable {

	private static final long serialVersionUID = 132423L;

//in a real app use an external mapper

	@SuppressWarnings({ "hiding", "unchecked" })
	public <D> D fromDTO(T t) {
		copyProperties(t, this);
		return (D) this;
	}

	public T toDTO(T t) {
		copyProperties(this, t);
		return t;
	}

	@Column(insertable = true, updatable = false)
	private Timestamp createTS;
	@Column()
	private Timestamp updateTS;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long serial = 0L;

	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public Timestamp getCreateTS() {
		return createTS;
	}

	public void setCreateTS(Timestamp createTS) {
		this.createTS = createTS;
	}

	public Timestamp getUpdateTS() {
		return updateTS;
	}

	public void setUpdateTS(Timestamp updateTS) {
		this.updateTS = updateTS;
	}

	@PrePersist
	void onCreate() {
		this.setCreateTS(new java.sql.Timestamp(new java.util.Date().getTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTS == null) ? 0 : createTS.hashCode());
		result = prime * result + ((updateTS == null) ? 0 : updateTS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDomain other = (AbstractDomain) obj;
		if (createTS == null) {
			if (other.createTS != null)
				return false;
		} else if (!createTS.equals(other.createTS))
			return false;
		if (updateTS == null) {
			if (other.updateTS != null)
				return false;
		} else if (!updateTS.equals(other.updateTS))
			return false;
		return true;
	}

}
