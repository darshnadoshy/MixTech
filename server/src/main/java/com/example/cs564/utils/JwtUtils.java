package com.example.cs564.utils;

import com.example.cs564.entity.CheckResult;
import io.jsonwebtoken.*;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * JWT token helper class
 *
 */

public class JwtUtils {
    /**
     *
     * @param id user id
     * @param subject
     * @param ttlMillis expire time
     * @return
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date();
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("admin")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttlMillis >= 0) {
            Date expDate = new Date(System.currentTimeMillis() + ttlMillis);
            builder.setExpiration(expDate); // expire time
        }
        return builder.compact();
    }

    /**
     * validate if JWT token is valid
     *
     * @param jwtStr JWT token
     * @return validation result
     */
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERR_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERR_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(SystemConstant.JWT_ERR_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * generate key for jwt token
     * @return key for jwt token
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * parse jwt token
     * @param jwt unparsed jwt token
     * @return parsed jwt token
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        return Jwts.parser()
                .setSigningKey(generalKey().getEncoded())
                .parseClaimsJws(jwt)
                .getBody();
    }
}
