package com.webback.controller.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HomeControllerModel {

	private String message;

	public HomeControllerModel(final String message) {
		this.message = message;
	}

	public HomeControllerModel() {

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

		if (obj instanceof HomeControllerModel) {

			final HomeControllerModel otherHome = (HomeControllerModel) obj;

			final EqualsBuilder builder = new EqualsBuilder();

			builder.append(this.message, otherHome.getMessage());

			return builder.build();
		}

		return false;
	}
}
