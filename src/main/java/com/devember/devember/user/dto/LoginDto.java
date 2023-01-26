package com.devember.devember.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class LoginDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String email;
        private String password;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String result;
        private String token;
        private String githubId;
        private String email;

        public static Response NotFoundUser(String githubId) {
            return Response.builder()
                    .result("fail")
                    .githubId(githubId)
                    .build();
        }

        public static Response from(String token) {
            return Response.builder()
                    .result("success")
                    .token(token)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SocialRequest {
        private String token;
    }
}
