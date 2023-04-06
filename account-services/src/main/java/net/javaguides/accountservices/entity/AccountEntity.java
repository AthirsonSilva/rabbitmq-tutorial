package net.javaguides.accountservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false)
	private String roleId;

	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private String createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private String updatedAt;
}
