package com.gridians.gridians.domain.card.entity;

import com.gridians.gridians.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sns extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_card_id")
	private ProfileCard profileCard;

	private String name;
	private String account;

	public static Sns from(ProfileCard profileCard, String name, String account){
		return Sns.builder()
				.profileCard(profileCard)
				.name(name)
				.account(account)
				.build();
	}
}
