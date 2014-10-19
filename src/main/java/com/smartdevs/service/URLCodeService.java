package com.smartdevs.service;

import org.apache.commons.lang.CharEncoding;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Kávai on 2014.10.19..
 */
@Path("url")
public class URLCodeService {
    @POST
    @Path("decode")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String decode(String data) throws UnsupportedEncodingException {
        return URLDecoder.decode(data, CharEncoding.UTF_8);
    }

    @POST
    @Path("encode")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String encode(String data) throws UnsupportedEncodingException {
        return URLEncoder.encode(data, CharEncoding.UTF_8);
    }
}
