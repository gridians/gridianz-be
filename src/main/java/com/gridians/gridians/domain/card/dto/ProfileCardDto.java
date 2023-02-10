package com.gridians.gridians.domain.card.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.gridians.gridians.domain.card.entity.*;
import com.gridians.gridians.domain.comment.dto.CommentDto;
import com.gridians.gridians.domain.user.entity.Github;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfileCardDto {

	@Getter
	@Setter
	public static class Request {

		@NotBlank
		private String statusMessage;
		@NotBlank
		private String introduction;
		@NotBlank
		private String field;
		@NotNull
		private String skill;
		@NotNull
		private Set<SnsResponse> snsSet;
		@NotNull
		private Set<String> tagSet;

	}

	@Getter
	@Setter
	@Builder
	public static class DetailResponse {

		private String statusMessage;
		private String field;

		private Set<String> tagSet;
		private String skill;
		private Set<SnsResponse> snsSet;

		private List<CommentDto.Response> commentList;
		private String imageSrc;

		private String githubName;
		private String githubAccount;

		private String githubProfileImageUrl;
		private String githubUrl;

		private LocalDate recentCommitAt;
		private String recentCommitMessage;

		private Long follower;
		private Long following;

		private String location;
		private String company;

		public static DetailResponse from(ProfileCard pc, List<CommentDto.Response> commentDtoList) {

			Set<String> skills = new HashSet<>();
			Set<SnsResponse> snss = new HashSet<>();
			Set<String> tags = new HashSet<>();

			Set<Sns> pcSnsSet = pc.getSnsSet();
			Set<Tag> pcTagSet = pc.getTagList();

			for (Sns s : pcSnsSet) {
				snss.add(SnsResponse.from(s));
			}

			for (Tag tag : pcTagSet) {
				tags.add(tag.getName());
			}

			return DetailResponse.builder()
					.commentList(commentDtoList)
					.statusMessage(pc.getStatusMessage())
					.field(pc.getField().getName())
					.skill(pc.getSkill().getName())
					.tagSet(tags)
					.snsSet(snss)
					.build();
		}

		public static DetailResponse from(Github github, ProfileCard pc, List<CommentDto.Response> commentDtoList) {

			Set<SnsResponse> snss = new HashSet<>();
			Set<String> tags = new HashSet<>();

			Set<Sns> pcSnsSet = pc.getSnsSet();
			Set<Tag> pcTagSet = pc.getTagList();

			for (Sns s : pcSnsSet) {
				snss.add(SnsResponse.from(s));
			}

			for (Tag tag : pcTagSet) {
				tags.add(tag.getName());
			}

			return DetailResponse.builder()
					.commentList(commentDtoList)
					.statusMessage(pc.getStatusMessage())
					.field(pc.getField().getName())
					.skill(pc.getSkill().getName())
					.tagSet(tags)
					.snsSet(snss)
					.githubName(github.getName())
					.githubAccount(github.getLogin())
					.githubProfileImageUrl(github.getProfileImageUrl())
					.recentCommitAt(github.getRecentCommitAt())
					.recentCommitMessage(github.getRecentCommitMessage())
					.follower(github.getFollowers())
					.following(github.getFollowing())
					.location(github.getLocation())
					.company(github.getCompany())
					.build();
		}
	}

	@Getter
	@Setter
	@Builder
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class SimpleResponse {

		private String field;
		private String imageSrc;
		private String nickname;
		private String skillSrc;
		private Long profileCardId;

		public static SimpleResponse from(ProfileCard pc) {

			return SimpleResponse.builder()
					.field(pc.getField() == null ? "" : pc.getField().getName())
					.nickname(pc.getUser() == null ? "" : pc.getUser().getNickname())
					.profileCardId(pc.getId())
					.build();
		}
	}

	@Builder
	@Setter
	@Getter
	public static class SnsResponse {

		private String name;
		private String account;

		public static SnsResponse from(Sns sns) {
			return SnsResponse.builder()
					.name(sns.getName())
					.account(sns.getAccount())
					.build();
		}
	}


	@Builder
	@Setter
	@Getter
	public static class GithubResponse {

		private String githubName;
		private String githubAccount;

		private String githubProfileImageUrl;
		private String githubUrl;

		private LocalDate recentCommitAt;
		private String recentCommitMessage;

		private Long follower;
		private Long following;

		private String location;
		private String company;

		public static GithubResponse from(Github github) {
			return GithubResponse.builder()
					.githubName(github.getName())
					.githubAccount(github.getLogin())
					.githubProfileImageUrl(github.getProfileImageUrl())
					.recentCommitAt(github.getRecentCommitAt())
					.recentCommitMessage(github.getRecentCommitMessage())
					.follower(github.getFollowers())
					.following(github.getFollowing())
					.location(github.getLocation())
					.company(github.getCompany())
					.build();
		}
	}
}
