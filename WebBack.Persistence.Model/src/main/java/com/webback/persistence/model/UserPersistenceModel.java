package com.webback.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "users")
public class UserPersistenceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	private String name;

	@NotNull
	private String username;

	private String password;

	private String salt;

	public UserPersistenceModel() {

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(final long userId) {
		this.userId = userId;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setSalt(final String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return this.salt;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("userId", this.userId)
				.append("name", this.name)
				.append("username", this.username)
				.append("password", this.password).append("salt", this.salt).toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final HashCodeBuilder builder = new HashCodeBuilder();

		builder.append(this.userId).append(this.name).append(this.username).append(this.password).append(this.salt);

		return builder.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {

		if (obj instanceof UserPersistenceModel) {

			final UserPersistenceModel otherUser = (UserPersistenceModel) obj;

			final EqualsBuilder builder = new EqualsBuilder();

			builder.append(this.userId, otherUser.getUserId()).append(this.name, otherUser.getName())
					.append(this.username, otherUser.getUsername()).append(this.password, otherUser.getPassword())
					.append(this.salt, otherUser.getSalt());

			return builder.build();
		}

		return false;
	}
}
