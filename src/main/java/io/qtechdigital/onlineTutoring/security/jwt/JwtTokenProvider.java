package io.qtechdigital.onlineTutoring.security.jwt;

import io.qtechdigital.onlineTutoring.config.property.AppProperties;
import io.qtechdigital.onlineTutoring.model.Role;
import io.qtechdigital.onlineTutoring.model.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Util class that provides methods for generation, validation, etc. of JWT token.
 */
@Component
public class JwtTokenProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private final AppProperties appProperties;

    public JwtTokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String createToken(Authentication authentication) {

        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .setSubject(Long.toString(jwtUser.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public String generateToken(User user) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()//
                .setSubject(Long.toString(user.getId()))//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, appProperties.getAuth().getTokenSecret())//
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());

        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }

        return false;
    }
}
