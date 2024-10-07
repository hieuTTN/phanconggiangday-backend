package com.web.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.web.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.Collections;

@Service
public class GoogleOAuth2Service {


    public GoogleIdToken.Payload verifyToken(String idTokenString) {

        try {
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jsonFactory)
                    .setAudience(Collections.singletonList("663646080535-l004tgn5o5cpspqdglrl3ckgjr3u8nbf.apps.googleusercontent.com"))
                    .build();
            System.out.println(verifier);
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                return payload;
            } else {
                return null;
            }
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}