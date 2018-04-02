package com.webback.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "test_table")
public class HomePersistenceModel {

	@Id
	private String message;

	public HomePersistenceModel(final String message) {
		this.message = message;
	}

	public HomePersistenceModel() {

	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("message", this.message).toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final HashCodeBuilder builder = new HashCodeBuilder();

		builder.append(this.message);

		return builder.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {

		if (obj instanceof HomePersistenceModel) {

			final HomePersistenceModel otherHome = (HomePersistenceModel) obj;

			final EqualsBuilder builder = new EqualsBuilder();

			builder.append(this.message, otherHome.getMessage());

			return builder.build();
		}

		return false;
	}
}
